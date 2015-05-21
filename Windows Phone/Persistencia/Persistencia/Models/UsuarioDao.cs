using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SQLite;
using System.IO;
using Windows.Storage;

namespace Persistencia.Models
{
    public class UsuarioDao
    {
        public String path = Path.Combine(ApplicationData.Current.LocalFolder.Path,"usuarios1.sqlite");
        public SQLiteConnection dbCon;
        public UsuarioDao()
        {
            var a = 0;
            dbCon = new SQLiteConnection(path);
            dbCon.CreateTable<Usuario>();
        }
        public int insertarUsuario(Usuario u)
        {
            int a=dbCon.Insert(u);
            return a;
        }
    }
}
