﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Persistencia_con.Net.Resources;
using System.IO.IsolatedStorage;
using System.IO;

namespace Persistencia_con.Net
{
    public partial class MainPage : PhoneApplicationPage
    {
        public static String pathfile = "archivo";
        // Constructor
        public MainPage()
        {
            InitializeComponent();
            readFile();
            // Código de ejemplo para traducir ApplicationBar
            //BuildLocalizedApplicationBar();
        }

        private void GuardarTexto(object sender, RoutedEventArgs e)
        {
            saveFile();
        }
        private void saveFile()
        {
            using(var isF=IsolatedStorageFile.GetUserStoreForApplication())
            {
                if (isF.FileExists(pathfile)) //Ya existe el archivo
                {
                    isF.DeleteFile(pathfile);   
                }
                using (var stream = isF.CreateFile(pathfile))
                {
                    using (StreamWriter writer = new StreamWriter(stream))
                    {
                        writer.WriteLine(TextoaCapturar.Text);
                        writer.Close();
                    }
                }
            }
        }
        private void readFile()
        {
            using(var isF=IsolatedStorageFile.GetUserStoreForApplication())
            {
                if(isF.FileExists(pathfile))
                {
                    using(var stream=isF.OpenFile(pathfile,FileMode.Open))
                    {
                        using(StreamReader reader=new StreamReader(stream))
                        {
                            String txt = reader.ReadLine();
                            TextoCapturado.Text = txt;
                        }
                    }
                }
            }
        }
        // Código de ejemplo para compilar una ApplicationBar traducida
        //private void BuildLocalizedApplicationBar()
        //{
        //    // Establecer ApplicationBar de la página en una nueva instancia de ApplicationBar.
        //    ApplicationBar = new ApplicationBar();

        //    // Crear un nuevo botón y establecer el valor de texto en la cadena traducida de AppResources.
        //    ApplicationBarIconButton appBarButton = new ApplicationBarIconButton(new Uri("/Assets/AppBar/appbar.add.rest.png", UriKind.Relative));
        //    appBarButton.Text = AppResources.AppBarButtonText;
        //    ApplicationBar.Buttons.Add(appBarButton);

        //    // Crear un nuevo elemento de menú con la cadena traducida de AppResources.
        //    ApplicationBarMenuItem appBarMenuItem = new ApplicationBarMenuItem(AppResources.AppBarMenuItemText);
        //    ApplicationBar.MenuItems.Add(appBarMenuItem);
        //}
    }
}