using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos.Models
{
    class Libros
    {
        private ObservableCollection<Libro> data;
        public ObservableCollection<Libro> Data 
        {
            get
            {
                if(data==null)
                {
                    data=new ObservableCollection<Libro>();
                    Libro libro1 = new Libro() { Nombre = "El jugador", Autor = "Fédor Dostoievski", Codigo = "2", Genero = "Novela", Paginas = 180 };
                    Libro libro2 = new Libro() { Nombre = "El amor en los tiempos del cólera", Autor = "Gabriel García Márquez", Codigo = "3", Genero = "Novela", Paginas = 346 };
                    Libro libro3 = new Libro() { Nombre = "Los tres Mosqueteros", Autor = "Alexandre Dumas", Codigo = "4", Genero = "Aventuras", Paginas = 400 };
                    data.Add(libro1);
                    data.Add(libro2);
                    data.Add(libro3);
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
