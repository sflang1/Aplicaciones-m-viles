using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Modelos.Models;

namespace Modelos
{
    public partial class LibrosPagina : PhoneApplicationPage
    {
        public LibrosPagina()
        {
            InitializeComponent();
        }

        private void EnviarInfo(object sender, RoutedEventArgs e)
        {
            var a=Lista.SelectedItems;
            Libro libro = Lista.SelectedItem as Libro;
            NavigationService.Navigate(new Uri("/Detalle.xaml?parametro="+libro.Codigo, UriKind.Relative));
        }
    }
}