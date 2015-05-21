using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RankedSoloQueue.Models
{
    public class Invocador
    {
        public int Existe {get;set;}
        public int Nivel { get; set; }
        public String SummonerName { get; set; }
        public String Region { get; set; }
        public String Liga { get; set; }
        public String PuntosLiga { get; set; }
        public String KDA { get; set; }
        public String Victorias { get; set; }
        public String Derrotas { get; set; }
        public String NomLiga { get; set; }
        public double Porcentaje { get; set; }
    }
}
