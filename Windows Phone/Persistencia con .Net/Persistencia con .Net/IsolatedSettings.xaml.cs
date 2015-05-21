using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using System.IO.IsolatedStorage;

namespace Persistencia_con.Net
{
    public partial class IsolatedSettings : PhoneApplicationPage
    {
        public const String TXT_KEY = "texto";
        public IsolatedSettings()
        {
            InitializeComponent();
            Leer();
        }

        private void Guardar(object sender, RoutedEventArgs e)
        {
            if(IsolatedStorageSettings.ApplicationSettings.Contains(TXT_KEY))
            {
                IsolatedStorageSettings.ApplicationSettings[TXT_KEY] = TextoaCapturar.Text;
            }
            else
            {
                IsolatedStorageSettings.ApplicationSettings.Add(TXT_KEY, TextoaCapturar.Text);
            }
            
        }
        private void Leer()
        {
            String txt;
            if(IsolatedStorageSettings.ApplicationSettings.Contains(TXT_KEY))
            {
                txt = IsolatedStorageSettings.ApplicationSettings[TXT_KEY] as String;
                TextoCapturado.Text = txt;
            }
        }
    }
}