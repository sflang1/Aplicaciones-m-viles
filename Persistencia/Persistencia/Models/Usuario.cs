using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SQLite;

namespace Persistencia.Models
{
    public class Usuario:INotifyPropertyChanged
    {
        private int id;
        private String nombre;
        private String apellido;
        private String username;
        private String password;
        [AutoIncrement, PrimaryKey]
        public int Id { get{return id;} set{id=value; if(PropertyChanged!=null){PropertyChanged(this,new PropertyChangedEventArgs("Id"));}} }
        public String Nombre { get {return nombre;} set{nombre=value; if(PropertyChanged!=null){PropertyChanged(this,new PropertyChangedEventArgs("Nombre"));}}}
        public String Apellido {get {return apellido;} set{apellido=value; if(PropertyChanged!=null){PropertyChanged(this,new PropertyChangedEventArgs("Apellido"));}}}
        public String Username {get {return username;} set{username=value; if(PropertyChanged!=null){PropertyChanged(this,new PropertyChangedEventArgs("Username"));}} }
        public String Password {get {return password;} set{password=value; if(PropertyChanged!=null){PropertyChanged(this,new PropertyChangedEventArgs("Password"));}} }
        public event PropertyChangedEventHandler PropertyChanged;
    }
}
