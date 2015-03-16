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
    public partial class Detalle : PhoneApplicationPage
    {
        public string param;
        public Detalle()
        {
            InitializeComponent();
        }
        protected override void OnNavigatedTo(System.Windows.Navigation.NavigationEventArgs e)
        {
            
            string parametro = string.Empty;
            int a=0;
            if (NavigationContext.QueryString.TryGetValue("parametro", out param))
            {
                Codigo.Text = param;
            }
            Libros libros = (Libros) Application.Current.Resources["Libros"];
            for (a = 0; a < libros.Data.Count;a++ )
            {
                if(libros.Data[a].Codigo.Equals(param))
                {
                    Nombre.Text = libros.Data[a].Nombre;
                    Autor.Text = libros.Data[a].Autor;
                    Genero.Text = libros.Data[a].Genero;
                    Pags.Text = "" + libros.Data[a].Paginas;
                }
                else
                {
                    Libro libro = new Libro();
                }
            }
           
            base.OnNavigatedTo(e);
        }
    }
    
}