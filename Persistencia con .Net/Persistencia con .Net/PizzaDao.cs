using SQLite;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Windows.Storage;

namespace Persistencia_con.Net
{
    public class PizzaDao
    {
        String pathDB = Path.Combine(ApplicationData.Current.LocalFolder.Path, "pizza.sqlite");
        SQLiteConnection con;
        public PizzaDao()
        {
            con = new SQLiteConnection(pathDB);
            con.CreateTable<Pizza>();
        }
        public int insertarPizza(Pizza Pizza)
        {
            return con.Insert(Pizza);
        }
        public int updatePizza(Pizza Pizza)
        {
            return con.Update(Pizza);
        }
        public int deletePizza(Pizza Pizza)
        {
            return con.Delete(Pizza);
        }
        public List<Pizza> listarPizzas()
        {
            return con.Table<Pizza>().ToList();
        }
        public List<Pizza> buscarPizza(String nombre)
        {
            List<Pizza> pizzas=con.Query<Pizza>("SELECT * FROM Pizza WHERE Nombre LIKE '%"+nombre+"%'");
            return pizzas;
        }
    }
}
