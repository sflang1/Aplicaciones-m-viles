using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Sen.HTMLParser.Resources;
using System.Collections.ObjectModel;
using HtmlAgilityPack;
using System.IO.IsolatedStorage;
using System.IO;
using System.Text;

namespace Sen.HTMLParser
{
    public partial class MainPage : PhoneApplicationPage
    {
        ObservableCollection<CodeSample> codes = new ObservableCollection<CodeSample>();
        public MainPage()
        {
            InitializeComponent();
            this.Loaded += MainPage_Loaded;
        }

        void MainPage_Loaded(object sender, RoutedEventArgs e)
        {
            WebClient codeSampleReq = new WebClient();
            codeSampleReq.DownloadStringCompleted += codeSampleReq_DownloadStringCompleted;
            codeSampleReq.DownloadStringAsync(new Uri("http://code.msdn.microsoft.com/"));
            CodeSamples.ItemsSource = codes;
        }

        void codeSampleReq_DownloadStringCompleted(object sender, DownloadStringCompletedEventArgs e)
        {
            try
            {
                HtmlDocument htmlDoc = new HtmlAgilityPack.HtmlDocument();
                htmlDoc.OptionFixNestedTags = true;
                htmlDoc.LoadHtml(e.Result);
                HtmlNode divContainer = htmlDoc.GetElementbyId("directoryItems");
                if (divContainer != null)
                {
                    HtmlNodeCollection nodes = divContainer.SelectNodes("//table/tr");
                    foreach (HtmlNode trNode in nodes)
                    {
                        CodeSample newSample = new CodeSample();
                        HtmlNode titleNode = trNode.SelectSingleNode("td[@class='itemBody']/div[@class='itemTitle']/a");
                        if (titleNode != null)
                        {
                            newSample.Title = titleNode.InnerHtml.Trim();
                        }

                        HtmlNode summaryNode = trNode.SelectSingleNode("td[@class='itemBody']/div/div[@class='customcontribution']/a");
                        if (summaryNode != null)
                        {
                            newSample.Summary = summaryNode.InnerHtml.Trim();
                        }
                        else
                        {
                            summaryNode = trNode.SelectSingleNode("td[@class='itemBody']/div/a[@class='profile-usercard-hover']");

                        }
                        if (summaryNode != null)
                        {
                            newSample.Summary = summaryNode.InnerHtml.Trim();
                        }
                        HtmlNode descNode = trNode.SelectSingleNode("td[@class='itemBody']/div[@class='summaryBox']");
                        if (descNode != null)
                        {
                            newSample.Description = descNode.InnerHtml.Trim();
                        }

                        HtmlNode divTech = trNode.SelectSingleNode("td[@class='itemBody']/div/div/div[@id='Technologies']");
                        if (divTech != null)
                        {
                            StringBuilder techNames = new StringBuilder();
                            foreach (HtmlNode techAnchor in divTech.ChildNodes)
                            {
                                if (techAnchor.Name.StartsWith("a"))
                                {
                                    techNames.Append(techAnchor.InnerHtml.Trim() + " ; ");
                                }
                            }
                            newSample.Technologies = techNames.ToString();
                        }
                        if (newSample.Technologies != null)
                        {
                            if (newSample.Technologies.ToString().ToLower().Contains("windows phone"))
                            {
                                newSample.ImageUrl = "/images/wp.jpg";
                            }
                            else if (newSample.Technologies.ToString().ToLower().Contains("windows store"))
                            {
                                newSample.ImageUrl = "/images/w8.png";
                            }
                            else if (newSample.Technologies.ToString().ToLower().Contains("visual studio"))
                            {
                                newSample.ImageUrl = "/images/vs.png";
                            }
                            else if (newSample.Technologies.ToString().ToLower().Contains("asp.net"))
                            {
                                newSample.ImageUrl = "/images/aspnet.png";
                            }
                            else
                            {
                                newSample.ImageUrl = "/images/net.jpg";
                            }
                        }
                        codes.Add(newSample);
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Unable to download" + ex.Message);
            }
        }


    }
}