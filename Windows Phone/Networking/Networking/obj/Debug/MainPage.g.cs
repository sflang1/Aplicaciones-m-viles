﻿#pragma checksum "D:\Universidad\Semestre X\Appli Móviles\Networking\Networking\MainPage.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "7DEC51DF77C144261019AB126AB1F02D"
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.34014
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using Microsoft.Phone.Controls;
using System;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Automation.Peers;
using System.Windows.Automation.Provider;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Interop;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Resources;
using System.Windows.Shapes;
using System.Windows.Threading;


namespace Networking {
    
    
    public partial class MainPage : Microsoft.Phone.Controls.PhoneApplicationPage {
        
        internal System.Windows.Controls.Grid LayoutRoot;
        
        internal System.Windows.Controls.Grid ContentPanel;
        
        internal System.Windows.Controls.TextBlock Temperatura;
        
        internal System.Windows.Controls.TextBlock Humedad;
        
        internal System.Windows.Controls.TextBlock Presion;
        
        internal System.Windows.Controls.TextBlock Pronostico;
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Windows.Application.LoadComponent(this, new System.Uri("/Networking;component/MainPage.xaml", System.UriKind.Relative));
            this.LayoutRoot = ((System.Windows.Controls.Grid)(this.FindName("LayoutRoot")));
            this.ContentPanel = ((System.Windows.Controls.Grid)(this.FindName("ContentPanel")));
            this.Temperatura = ((System.Windows.Controls.TextBlock)(this.FindName("Temperatura")));
            this.Humedad = ((System.Windows.Controls.TextBlock)(this.FindName("Humedad")));
            this.Presion = ((System.Windows.Controls.TextBlock)(this.FindName("Presion")));
            this.Pronostico = ((System.Windows.Controls.TextBlock)(this.FindName("Pronostico")));
        }
    }
}

