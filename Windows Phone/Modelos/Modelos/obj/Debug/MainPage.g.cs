﻿#pragma checksum "D:\Universidad\Semestre X\Appli Móviles\Modelos\Modelos\MainPage.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "44021F3F22030713A045855F9260114F"
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


namespace Modelos {
    
    
    public partial class MainPage : Microsoft.Phone.Controls.PhoneApplicationPage {
        
        internal System.Windows.Controls.Grid LayoutRoot;
        
        internal System.Windows.Controls.Grid ContentPanel;
        
        internal System.Windows.Controls.TextBox Nombre;
        
        internal System.Windows.Controls.TextBox Autor;
        
        internal System.Windows.Controls.TextBox Genero;
        
        internal System.Windows.Controls.TextBox Codigo;
        
        internal System.Windows.Controls.TextBox Pags;
        
        internal System.Windows.Controls.Button Aceptar;
        
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
            System.Windows.Application.LoadComponent(this, new System.Uri("/Modelos;component/MainPage.xaml", System.UriKind.Relative));
            this.LayoutRoot = ((System.Windows.Controls.Grid)(this.FindName("LayoutRoot")));
            this.ContentPanel = ((System.Windows.Controls.Grid)(this.FindName("ContentPanel")));
            this.Nombre = ((System.Windows.Controls.TextBox)(this.FindName("Nombre")));
            this.Autor = ((System.Windows.Controls.TextBox)(this.FindName("Autor")));
            this.Genero = ((System.Windows.Controls.TextBox)(this.FindName("Genero")));
            this.Codigo = ((System.Windows.Controls.TextBox)(this.FindName("Codigo")));
            this.Pags = ((System.Windows.Controls.TextBox)(this.FindName("Pags")));
            this.Aceptar = ((System.Windows.Controls.Button)(this.FindName("Aceptar")));
        }
    }
}

