using System;
using System.Collections.Generic;
using System.Linq;
//using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using System.Collections.ObjectModel;
using RankedSoloQueue.Net;
using RankedSoloQueue.Models;
using System.Windows.Media.Imaging;

namespace RankedSoloQueue
{
    public partial class principal : PhoneApplicationPage
    {
        
        private String summonerName;
        private String reg;
        public principal()
        {
            InitializeComponent();
            
        }
        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            //List<String> claves = { "nombre", "region" };
            /*if(NavigationContext.QueryString.Contains("nombre"))
            {

            }*/
            //summonerName=NavigationContext.QueryString["nombre"];
            //reg = NavigationContext.QueryString["region"];
            Invocador i = new Invocador();
            i = PhoneApplicationService.Current.State["param"] as Invocador;
            //invocador.Text = i.SummonerName;
            //region.Text = i.Region;
            pivot.DataContext = i;
            BitmapImage bi3 = new BitmapImage();
            if(i.Liga.Contains("Unranked"))
            {
                bi3.UriSource = new Uri("Assets/Unranked.png", UriKind.Relative);
            }
            if(i.Liga.Contains("Bronce"))
            {
                bi3.UriSource = new Uri("Assets/Bronze.png", UriKind.Relative);
            }
            if (i.Liga.Contains("Plata"))
            {
                bi3.UriSource = new Uri("Assets/Silver.png", UriKind.Relative);
            }
            if (i.Liga.Contains("Oro"))
            {
                bi3.UriSource = new Uri("Assets/Gold.png", UriKind.Relative);
            }
            if (i.Liga.Contains("Platino"))
            {
                bi3.UriSource = new Uri("Assets/Platinum.png", UriKind.Relative);
            }
            if (i.Liga.Contains("Diamante"))
            {
                bi3.UriSource = new Uri("Assets/Diamond.png", UriKind.Relative);
            }
            if (i.Liga.Contains("Challenger"))
            {
                bi3.UriSource = new Uri("Assets/Challenger.png", UriKind.Relative);
            }
            
            image.Source = bi3;
            NavigationService.RemoveBackEntry();
            base.OnNavigatedTo(e);
        }

        private void nuevaBusqueda(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/MainPage.xaml",UriKind.Relative));
        }

        
       
    }
}