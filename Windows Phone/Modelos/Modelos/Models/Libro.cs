using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos.Models
{
    public class Libro:INotifyPropertyChanged
    {
        private String nombre;
        private String codigo;
        private String genero;
        private String autor;
        private int paginas;
        public String Nombre { get { return nombre; } set { nombre = value; if (PropertyChanged != null) { PropertyChanged(this,new PropertyChangedEventArgs("Nombre")); } } }
        public String Codigo { get { return codigo; } set { codigo = value; if (PropertyChanged != null) { PropertyChanged(this, new PropertyChangedEventArgs("Codigo")); } } }
        public String Genero { get { return genero; } set { genero = value; if (PropertyChanged != null) { PropertyChanged(this, new PropertyChangedEventArgs("Genero")); } } }
        public String Autor { get { return autor; } set { autor = value; if (PropertyChanged != null) { PropertyChanged(this, new PropertyChangedEventArgs("Autor")); } } }
        public int Paginas { get { return paginas; } set { paginas = value; if (PropertyChanged != null) { PropertyChanged(this, new PropertyChangedEventArgs("Paginas")); } } }

        public event PropertyChangedEventHandler PropertyChanged;
    }
}
