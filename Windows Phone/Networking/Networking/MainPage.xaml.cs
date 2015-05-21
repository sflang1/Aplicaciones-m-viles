using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Networking.Resources;
using Networking.Net;

namespace Networking
{
    public partial class MainPage : PhoneApplicationPage,WeatherClient.Iweather
    {
        // Constructor
        WeatherClient client;
        public MainPage()
        {
            InitializeComponent();
            client = new WeatherClient(this);
            client.getWeather();
            // Código de ejemplo para traducir ApplicationBar
            //BuildLocalizedApplicationBar();
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

        public void putWeather(Models.Clima w)
        {
            Temperatura.Text = w.Temperatura;
            Presion.Text = w.Presion;
            Pronostico.Text = w.Pronostico;
            Humedad.Text = w.Humedad;
        }
    }
}