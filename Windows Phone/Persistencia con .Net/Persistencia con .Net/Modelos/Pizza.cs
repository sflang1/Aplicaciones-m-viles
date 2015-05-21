using SQLite;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Persistencia_con.Net
{
    public class Pizza
    {
        [PrimaryKey,AutoIncrement]
        public int Id { get; set; }
        public String Nombre { get; set; }
        public int Precio { get; set; }
        public int Tamano { get; set; }
    }
}

