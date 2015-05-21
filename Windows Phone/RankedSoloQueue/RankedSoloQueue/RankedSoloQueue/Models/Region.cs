using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RankedSoloQueue.Models
{
    public class Region:INotifyPropertyChanged
    {
        private String nomRegion;
        public String NomRegion
        {
            get
            {
                return nomRegion;
            }
            set
            {
                nomRegion = value;
            }

        }

        public event PropertyChangedEventHandler PropertyChanged;
    }
}
