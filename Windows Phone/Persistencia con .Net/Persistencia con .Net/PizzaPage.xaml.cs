using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace Persistencia_con.Net
{
    public partial class PizzaPage : PhoneApplicationPage
    {
        PizzaDao pdao;
        public PizzaPage()
        {
            InitializeComponent();
            pdao = new PizzaDao();
        }

        private void InsertarPizza(object sender, RoutedEventArgs e)
        {
            
            
        }
    }
}