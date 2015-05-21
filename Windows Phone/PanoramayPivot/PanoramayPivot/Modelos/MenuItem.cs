using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PanoramayPivot.Modelos
{
    public class MenuItem:INotifyPropertyChanged
    {
        private String titulo;
        private String descripcion;
        public String Descripcion { get { return descripcion; } set { descripcion = value; if (PropertyChanged != null) { PropertyChanged(this, new PropertyChangedEventArgs("Descripcion")); } } }
        public String Titulo { get { return titulo; } set { titulo = value; if (PropertyChanged != null) {PropertyChanged(this,new PropertyChangedEventArgs("Titulo"));} } }


        public event PropertyChangedEventHandler PropertyChanged;
    }
}
