using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using PanoramayPivot.Resources;
using PanoramayPivot.Modelos;

namespace PanoramayPivot
{
    public partial class MainPage : PhoneApplicationPage
    {
        // Constructor
        public MainPage()
        {
            InitializeComponent();

            // Código de ejemplo para traducir ApplicationBar
            //BuildLocalizedApplicationBar();
        }

        private void Seleccion(object sender, SelectionChangedEventArgs e)
        {
            var SelectedItem = Lista.SelectedItem as MenuItem;
            if(SelectedItem.Titulo=="Panorama")
            {
                NavigationService.Navigate( new Uri("/Panorama.xaml?texto=El texto del panorama",UriKind.Relative));

            }
            else
            {
                NavigationService.Navigate(new Uri("/Pivot.xaml?texto=El texto del pivot",UriKind.Relative));
            }
        }

         //Código de ejemplo para compilar una ApplicationBar traducida
        private void BuildLocalizedApplicationBar()
        {
            // Establecer ApplicationBar de la página en una nueva instancia de ApplicationBar.
            ApplicationBar = new ApplicationBar();

            // Crear un nuevo botón y establecer el valor de texto en la cadena traducida de AppResources.
            ApplicationBarIconButton appBarButton = new ApplicationBarIconButton(new Uri("/Assets/Icons/add.png", UriKind.Relative));
            appBarButton.Text = "Agregar";
            ApplicationBar.Buttons.Add(appBarButton);
            ApplicationBarIconButton appBarButton2 = new ApplicationBarIconButton(new Uri("/Assets/Icons/edit.png", UriKind.Relative));
            appBarButton2.Text = "Editar";
            ApplicationBar.Buttons.Add(appBarButton2);
            ApplicationBarIconButton appBarButton3 = new ApplicationBarIconButton(new Uri("/Assets/Icons/stop.png", UriKind.Relative));
            appBarButton3.Text = "Parar";
            ApplicationBar.Buttons.Add(appBarButton3);

            // Crear un nuevo elemento de menú con la cadena traducida de AppResources.
            ApplicationBarMenuItem appBarMenuItem = new ApplicationBarMenuItem("Empezar");
            ApplicationBar.MenuItems.Add(appBarMenuItem);
        }
    }
}