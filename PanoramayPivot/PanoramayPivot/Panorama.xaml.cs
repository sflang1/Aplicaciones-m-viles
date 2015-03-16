using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace PanoramayPivot
{
    public partial class Page1 : PhoneApplicationPage
    {
        public Page1()
        {
            InitializeComponent();
        }
        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            if(NavigationContext.QueryString.ContainsKey("texto"))
            {
                Panorama.Header = NavigationContext.QueryString["texto"];
            }
            base.OnNavigatedTo(e);
        }
    }
}