using Networking.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;


namespace Networking.Net
{
    public class WeatherClient
    {
        //URL del clima de Popayán
        const String URL = "https://www.google.com.co/?gws_rd=cr,ssl&ei=mnULVaCOK9PjsATm1oDYDQ&safe=active&ssui=on";
        HttpClient client;
        Iweather w;
        public interface Iweather
        {
            void putWeather(Clima w);
        }
        public WeatherClient(Iweather w)
        {
            client = new HttpClient();
            this.w = w;
        }
        public async void getWeather()
        {
            HttpResponseMessage msj = await client.GetAsync(new Uri(URL));
            String XML = msj.ToString();
            XDocument doc = XDocument.Parse(XML);
            XElement results=doc.Root.Element("results");
            XElement chanel = results.Element("channel");
            XElement atmosphere = chanel.Element("yweather:atmosphere");
            XElement item = chanel.Element("item");
            String temperatura = item.Element("yweather:condition").Attribute("temp").Value;
            String pronostico = item.Element("yweather:condition").Attribute("text").Value;
            String humedad = atmosphere.Attribute("humidity").Value;
            String presion = atmosphere.Attribute("pressure").Value;
            Clima clima = new Clima() { Presion = presion, Humedad = humedad, Pronostico = pronostico, Temperatura = temperatura };
            w.putWeather(clima);
        }
        
    }
}
