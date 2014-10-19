using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Threading;

namespace FinSostAnalitic
{
    public partial class Form2 : Form
    {
        string Current;

        RegClient regClient = new RegClient();
        Client client;

        Adress adressHome = new Adress();
        Adress adressUr = new Adress();
        List<Family> clientFam;
        ListClients form;
        #region Construcor

        public Form2(string cur)
        {

            InitializeComponent();
            Current = cur;
            string str = "Форма добавления (изменения) контрагентов";
            this.Text = str + " / " + Current;

        }
        public Form2(string cur, string inn)
        {

            InitializeComponent();
            Current = cur;
            string str = "Форма добавления (изменения) контрагентов";
            this.Text = str + " / " + Current;

            client = regClient.ClientSearcher(inn);
            textBox4.Text = client.INN;
            textBox1.Text = client.Name;
            dateTimePicker2.Value = client.DateBirsday;
            comboBox2.Text = client.Residantance;
            textBox2.Text = client.WhereWork;
            textBox3.Text = client.Position;
            comboBox3.Text = client.Mariied;
            Console.WriteLine(client.ID);

            adressUr = regClient.AdressSeaherU(client.ID);
            adressHome = regClient.AdressSeaherH(client.ID);
            textBox5.Text = adressUr.Country;
            textBox6.Text = adressUr.Area;
            textBox7.Text = adressUr.City;
            textBox8.Text = adressUr.Street;
            textBox9.Text = adressUr.House;
            textBox10.Text = adressUr.Appartment;
            textBox11.Text = adressUr.ZIPCode.ToString();
            textBox18.Text = adressHome.Country;
            textBox17.Text = adressHome.Area;
            textBox16.Text = adressHome.City;
            textBox15.Text = adressHome.Street;
            textBox14.Text = adressHome.House;
            textBox13.Text = adressHome.Appartment;
            textBox12.Text = adressHome.ZIPCode.ToString();

            clientFam = regClient.ClientFamilySeacher(client.ID);
            Console.WriteLine(clientFam.Count);
            if (clientFam.Count > 0)
            {
                this.dataGridView1.DataSource = null;
                this.dataGridView1.DataSource = clientFam;
            }


        }
        #endregion

        #region GET
        //return name of Client
        public TextBox TextBox1
        {
            get
            {
                return textBox1;
            }
        }
        //return INN of Client
        public TextBox TextBox4
        {
            get
            {
                return textBox4;
            }
        }
        //return birthday of Client
        public DateTimePicker DateTimePicker2
        {
            get
            {
                return dateTimePicker2;
            }
        }

        //return residentance of Client
        public ComboBox ComboBox2
        {
            get
            {
                return comboBox2;
            }
        }
        //return work place of Client
        public TextBox TextBox2
        {
            get
            {
                return textBox2;
            }
        }
        //return position of Client
        public TextBox TextBox3
        {
            get
            {
                return textBox3;
            }
        }
        //return status married of Client
        public ComboBox ComboBox3
        {
            get
            {
                return comboBox3;
            }
        }

        //return Country of Official Asress of Client
        public TextBox TextBox5
        {
            get
            {
                return textBox5;
            }
        }
        //return Area of Official Asress of Client
        public TextBox TextBox6
        {
            get
            {
                return textBox6;
            }
        }

        //return City of Official Asress of Client
        public TextBox TextBox7
        {
            get
            {
                return textBox7;
            }
        }

        //return Street of Official Asress of Client
        public TextBox TextBox8
        {
            get
            {
                return textBox8;
            }
        }
        //return House of Official Asress of Client
        public TextBox TextBox9
        {
            get
            {
                return textBox9;
            }
        }
        //return Appartment of Official Asress of Client
        public TextBox TextBox10
        {
            get
            {
                return textBox10;
            }
        }
        //return ZiP CODE of Official Asress of Client
        public TextBox TextBox11
        {
            get
            {
                return textBox11;
            }
        }

        //return Country of Fact Asress of Client
        public TextBox TextBox18
        {
            get
            {
                return textBox18;
            }
        }
        //return Area of Fact Asress of Client
        public TextBox TextBox17
        {
            get
            {
                return textBox17;
            }
        }

        //return City of Fact Asress of Client
        public TextBox TextBox16
        {
            get
            {
                return textBox16;
            }
        }

        //return Street of Fact Asress of Client
        public TextBox TextBox15
        {
            get
            {
                return textBox15;
            }
        }
        //return House of Fact Asress of Client
        public TextBox TextBox14
        {
            get
            {
                return textBox14;
            }
        }
        //return Appartment of Fact Asress of Client
        public TextBox TextBox13
        {
            get
            {
                return textBox13;
            }
        }
        //return ZiP CODE of Fact Asress of Client
        public TextBox TextBox12
        {
            get
            {
                return textBox12;
            }
        }
        //return family of Client
        public List<Family> DataGridView1
        {
            get
            {
                return (List<Family>)dataGridView1.DataSource;
            }
        }
        #endregion

        // SAVE Client to DB
        private void button1_Click(object sender, EventArgs e)
        {
            string name = textBox1.Text;
            string inn = textBox4.Text;
            DateTime birsday = dateTimePicker2.Value;
            string resident = comboBox2.Text;
            string work = textBox2.Text;
            string position = textBox3.Text;
            string mariied = comboBox3.Text;
            string countryU = textBox5.Text;
            string areaU = textBox6.Text;
            string cityU = textBox7.Text;
            string streetU = textBox8.Text;
            string houseU = textBox9.Text;
            string appartmentU = textBox10.Text;
            int zipCodeU;
            if (!string.IsNullOrEmpty(textBox11.Text))
            {
                zipCodeU = Convert.ToInt32(textBox11.Text);
            }
            else zipCodeU = 111;

            string countryH = textBox18.Text;
            string areaH = textBox17.Text;
            string cityH = textBox16.Text;
            string streetH = textBox15.Text;
            string houseH = textBox14.Text;
            string appartmentH = textBox13.Text;
            int zipCodeH;
            if (!string.IsNullOrEmpty(textBox12.Text))
            {
                zipCodeH = Convert.ToInt32(textBox12.Text);
            }
            else zipCodeH = 111;

            if (!regClient.ClientSearch(inn))
            {
                regClient.SaveClientToDB(name, inn, resident, birsday, work, position, mariied);
            }
            else
                MessageBox.Show("Клиент с таким ИНН уже существует в БД");
            int id;
            client = regClient.ClientSearcher(inn);
            id = client.ID;
            regClient.SaveAdressToDB(id, countryU, areaU, cityU, streetU, houseU, appartmentU, zipCodeU, 0);
            regClient.SaveAdressToDB(id, countryH, areaH, cityH, streetH, houseH, appartmentH, zipCodeH, 1);

            for (int i = 0; i < dataGridView1.Rows.Count - 1; i++)
            {

                //    dataGridView1.MultiSelect = false;

                string fname = dataGridView1.Rows[i].Cells[1].Value.ToString();
                DateTime fdate = Convert.ToDateTime(dataGridView1.Rows[i].Cells[2].Value.ToString());
                string fwho = dataGridView1.Rows[i].Cells[3].Value.ToString();
                regClient.SaveFamilyToDB(id, fname, fdate, fwho);
            }

            MessageBox.Show("Клиент успешно сохранен в БД");

            form = new ListClients(Current);
            Thread th = new Thread(P => form.ShowDialog());
            th.Start();
            this.Close();
        }

        // Check is Client in DB by INN
        private void button2_Click(object sender, EventArgs e)
        {
            if (regClient.ClientSearch(textBox4.Text) == false)
            {
                MessageBox.Show("Клиент отсутствует в БД");
            }
            else
            {
                client = regClient.ClientSearcher(textBox4.Text);
                textBox1.Text = client.Name;
                dateTimePicker2.Value = client.DateBirsday;
                comboBox2.Text = client.Residantance;
                textBox2.Text = client.WhereWork;
                textBox3.Text = client.Position;
                comboBox3.Text = client.Mariied;
                Console.WriteLine(client.ID);

                adressUr = regClient.AdressSeaherU(client.ID);
                adressHome = regClient.AdressSeaherH(client.ID);
                textBox5.Text = adressUr.Country;
                textBox6.Text = adressUr.Area;
                textBox7.Text = adressUr.City;
                textBox8.Text = adressUr.Street;
                textBox9.Text = adressUr.House;
                textBox10.Text = adressUr.Appartment;
                textBox11.Text = adressUr.ZIPCode.ToString();
                textBox18.Text = adressHome.Country;
                textBox17.Text = adressHome.Area;
                textBox16.Text = adressHome.City;
                textBox15.Text = adressHome.Street;
                textBox14.Text = adressHome.House;
                textBox13.Text = adressHome.Appartment;
                textBox12.Text = adressHome.ZIPCode.ToString();

                clientFam = regClient.ClientFamilySeacher(client.ID);
                Console.WriteLine(clientFam.Count);
                if (clientFam.Count > 0)
                {
                    this.dataGridView1.DataSource = null;
                    this.dataGridView1.DataSource = clientFam;
                }
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            regClient.SubmitClientChanges(this, this.textBox4.Text);
            form = new ListClients(Current);
            Thread th = new Thread(P => form.ShowDialog());
            th.Start();
            this.Close();

        }
    }
}