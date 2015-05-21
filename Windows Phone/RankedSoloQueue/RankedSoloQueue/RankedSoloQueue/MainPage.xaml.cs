using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Windows.ApplicationModel;
using RankedSoloQueue.Resources;
using System.Resources;
using RankedSoloQueue.Models;


namespace RankedSoloQueue
{
    
    public partial class MainPage : PhoneApplicationPage,RankedSoloQueue.Net.WebClient.IWeb
    {
        protected Invocador invocador;
        // Constructor
        public MainPage()
        {
            InitializeComponent();
            // Código de ejemplo para traducir ApplicationBar
            //BuildLocalizedApplicationBar();
        }

        private void buscarInvocador(object sender, RoutedEventArgs e)
        {
            existe.Text = "";
            int index = listaRegiones.SelectedIndex;
            String nombre = summonerName.Text;
            Regiones r = new Regiones();
            String a = r.Data[index].NomRegion;
            RankedSoloQueue.Net.WebClient client = new RankedSoloQueue.Net.WebClient(nombre, a, this);
            client.getSummoner();
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

        public void putWeather(Invocador i)
        {
            invocador=i;
            switch(i.Existe)
            {
                case -2:
                    existe.Text = "Error de programación";
                    break;
                case -1:
                    existe.Text = "Probablemente no hay Internet. Comprueba tu conexión";
                    break;
                case 0:
                    existe.Text = "El invocador no existe. Inténtalo de nuevo";
                    break;
                case 1:
                    int index = listaRegiones.SelectedIndex;
                    Regiones r = new Regiones();
                    String nombredelaRegion = r.Data[index].NomRegion;
                    PhoneApplicationService.Current.State["param"] = invocador;
                    NavigationService.Navigate(new Uri("/principal.xaml", UriKind.Relative));
                    break;
            }
        }
    }
}