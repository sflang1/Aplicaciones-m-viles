using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PanoramayPivot.Modelos
{
    public class Menu
    {
        private ObservableCollection<MenuItem> data;
        public ObservableCollection<MenuItem> Data { 
            get 
            { 
                if(data==null)
                {
                    data = new ObservableCollection<MenuItem>();
                    MenuItem i1 = new MenuItem() { Titulo = "Panorama", Descripcion = "Ejemplo de panorama" };
                    MenuItem i2 = new MenuItem() { Titulo = "Pivot", Descripcion = "Ejemplo de pivot" };
                    data.Add(i1);
                    data.Add(i2);
                }
                
                    return data; 
                
                
            } 
            set 
            {
                data = value;
            } 
        }
    }
}
