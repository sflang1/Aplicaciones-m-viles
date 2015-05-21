using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RankedSoloQueue.Models
{
    public class Regiones
    {
        private ObservableCollection<Region> data;
        public ObservableCollection<Region> Data
        {
            get
            {
                if(data==null)
                {
                    data = new ObservableCollection<Region>();
                    Region region1 = new Region() { NomRegion = "LAN" };
                    Region region2 = new Region() { NomRegion = "LAS" };
                    Region region3 = new Region() { NomRegion = "EUW" };
                    Region region4 = new Region() { NomRegion = "EUNE" };
                    Region region5 = new Region() { NomRegion = "RU" };
                    Region region6 = new Region() { NomRegion = "TR" };
                    Region region7 = new Region() { NomRegion = "KR" };
                    Region region8 = new Region() { NomRegion = "OCE" };
                    Region region9 = new Region() { NomRegion = "BR" };
                    Region region10 = new Region() { NomRegion = "NA" };
                    data.Add(region1);
                    data.Add(region2);
                    data.Add(region3);
                    data.Add(region4);
                    data.Add(region5);
                    data.Add(region6);
                    data.Add(region7);
                    data.Add(region8);
                    data.Add(region9);
                    data.Add(region10);
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
