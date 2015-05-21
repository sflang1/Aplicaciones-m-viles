using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Windows.Web.Http;
using RankedSoloQueue.Models;
using HtmlAgilityPack;
using System.Xml.XPath;

namespace RankedSoloQueue.Net
{
    public class WebClient
    {
        public interface IWeb
        {
            void putWeather(Invocador i);
        }
        const String url = "http://www.lolskill.net/summoner/"; 
        HttpClient client;
        String nomBusqueda;
        String regBusqueda;
        IWeb iweb;
        public WebClient(String nom,String reg,IWeb iweb)
        {
            client = new HttpClient();
            nomBusqueda = nom;
            regBusqueda = reg;
            this.iweb = iweb;

            Invocador inv = new Invocador();
            inv.SummonerName = nomBusqueda;
            inv.Region = reg;

        }
        public async void getSummoner()
        {
            String cadena = url + regBusqueda + "/" + nomBusqueda + "/summary";
            HttpResponseMessage msg = null;
            int exists = 1;
            var a = 0;
            String prueba = "";
            Invocador i = new Invocador();
            try
            {
                msg = await client.GetAsync(new Uri(cadena));
            }
            catch (Exception e)
            {
                Console.WriteLine("Probablemente no hay internet");
                i.Existe = -1;
                iweb.putWeather(i);
                return;
            }
            String response = "";
            response = msg.Content.ToString();
            var doc = new HtmlDocument();
            doc.LoadHtml(response);
            HtmlNode node = doc.GetElementbyId("content");
            try
            {
                HtmlNodeCollection headers = node.SelectNodes("//div[@class='head']/h3");
                HtmlNode header = headers[0];
                if (header.InnerText.Equals("Summoner Not Found"))
                {
                    i.Existe = 0;
                }
                else
                {
                    i.Existe = 1;
                    i.SummonerName = nomBusqueda;
                    i.Region = regBusqueda;
                    HtmlNodeCollection boxes = node.SelectNodes("//div[@class='box']/h3");
                    HtmlNode box = boxes[0];
                    prueba = box.InnerText;
                    int start=prueba.IndexOf("L");
                    int final=prueba.IndexOf("&");
                    String nivelCadena=prueba.Substring(prueba.IndexOf("L"),final-start);
                    start = nivelCadena.IndexOf(" ");
                    int nivel = Convert.ToInt32(nivelCadena.Substring(start));
                    i.Nivel = nivel;
                    if(i.Nivel<30)
                    {
                        i.Liga = "Unranked";
                        i.Porcentaje = 0;
                        i.Victorias = "0V";
                        i.Derrotas = "0D";
                        i.KDA = "0";
                        i.NomLiga = "0";
                        i.PuntosLiga = "0 LP";
                    }
                    else
                    {
                        HtmlNode rankedsoloqueues = doc.GetElementbyId("rankedsolo");
                        HtmlNode rankedsoloqueue = rankedsoloqueues.SelectNodes("//div[@class='body']")[0];
                        HtmlNode tier = rankedsoloqueue.SelectNodes("//p[@class='tier']")[1];
                        HtmlNode leaguepoints = rankedsoloqueue.SelectSingleNode("//p[@class='leaguepoints']");
                        HtmlNode kda = rankedsoloqueue.SelectSingleNode("//p[@class='kda']");
                        HtmlNode wins = rankedsoloqueue.SelectSingleNode("//span[@class='wins']");
                        HtmlNode losses = rankedsoloqueue.SelectSingleNode("//span[@class='losses']");
                        HtmlNode leaguename = rankedsoloqueue.SelectSingleNode("//p[@class='leaguename']");
                        String tieri = tier.InnerText;
                        if(tieri.Equals("Unranked "))
                        {
                            i.Liga = "Unranked";
                            i.Porcentaje = 0;
                            i.Victorias = "0V";
                            i.Derrotas = "0D";
                            i.KDA = "0";
                            i.NomLiga = "0";
                            i.PuntosLiga = "0 LP";
                        }
                        else
                        {
                            tieri = tieri.Replace("Bronze", "Bronce");
                            tieri = tieri.Replace("Silver", "Plata");
                            tieri = tieri.Replace("Gold", "Oro");
                            tieri = tieri.Replace("Platinum", "Platino");
                            tieri = tieri.Replace("Diamond", "Diamante");
                            i.Liga = tieri;
                            String ptosligai = leaguepoints.InnerText;
                            ptosligai = ptosligai.Replace("League Points", "LP");
                            i.PuntosLiga = ptosligai;
                            String kdai = kda.InnerText;
                            kdai = kdai.Replace("&ndash;", " ");
                            i.KDA = kdai;
                            String victoriasi = wins.InnerText;
                            victoriasi = victoriasi.Replace("W", "V");
                            i.Victorias = victoriasi;
                            String derrotasi = losses.InnerText;
                            derrotasi = derrotasi.Replace("L", "D");
                            double porc, vic, derr;
                            String parsev = victoriasi.Substring(0, victoriasi.IndexOf("V") - 1);
                            String parsed = derrotasi.Substring(0, derrotasi.IndexOf("D") - 1);
                            vic = Convert.ToDouble(parsev);
                            derr = Convert.ToDouble(parsed);
                            porc = vic / (vic + derr) * 100;
                            porc = Math.Round(porc, 1);
                            i.Porcentaje = porc;
                            a = 0;
                            i.Derrotas = derrotasi;
                            i.NomLiga = leaguename.InnerText;
                        }
                    }
                }
            }
            catch (NullReferenceException e)
            {
                Console.WriteLine("El nodo no ha sido encontrado en el texto HTML. Error de programación");
                i.Existe=-2;
            }
            iweb.putWeather(i);
        }
        
    }
}
