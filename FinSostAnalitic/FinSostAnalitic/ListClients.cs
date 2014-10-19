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
    public partial class ListClients : Form
    {
        string Current;
        RegClient regClient = new RegClient();
        List<Client> clients;
        Form2 form;
        Client client;
        Form_Credits formCredit;
        Form_Ocenka formOcenka;
        History history;
       
        #region Constructor
        
        public ListClients(string cur)
        {
            InitializeComponent();
            Current = cur;
            string str = "Контрагенты";
            this.Text = str + " / " + Current;

            clients=regClient.ClientsSeacher();
            dataGridView1.DataSource = clients;

        }
        #endregion
        //create form to adding client
        private void button1_Click(object sender, EventArgs e)
        {
            form = new Form2(Current);
            Thread thRegCl = new Thread(P1 => form.ShowDialog());
            thRegCl.Start();
            this.Close();
        }
      
        //return List of clients
        public List<Client> getClients()
        {
            return this.clients;
        }

        //create form to change client and save this changes to database
        private void button2_Click(object sender, EventArgs e)
        {
            string inn = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();
            Console.WriteLine(inn);
            client = regClient.ClientSearcher(inn);
          
            Console.WriteLine(client.Name);

            form = new Form2(Current, inn);
            Thread thRegCl = new Thread(P1 => form.ShowDialog());
            thRegCl.Start();
            //int index = form.Controls.IndexOfKey("textBox4");
            this.Close();
        }
        
        //delete client from database
        private void button4_Click(object sender, EventArgs e)
        {
            string inn = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();
            regClient.DeleteClient(inn);
            this.dataGridView1.DataSource = null;
            clients = regClient.ClientsSeacher();
            dataGridView1.DataSource = clients;
        }
        
        //load form manage credits
        private void button5_Click(object sender, EventArgs e)
        {
            string inn = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();

            formCredit = new Form_Credits(Current, inn);
            Thread thRegCl = new Thread(P1 => formCredit.ShowDialog());
            thRegCl.Start();
            this.Close();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            string inn = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();

            formOcenka = new Form_Ocenka(Current, inn);
            Thread thRegCl = new Thread(P1 => formOcenka.ShowDialog());
            thRegCl.Start();
            this.Close();
        }

        private void button6_Click(object sender, EventArgs e)
        {
           int id = int.Parse(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());

            history = new History(Current, id);
            Thread thRegCl = new Thread(P1 => history.ShowDialog());
            thRegCl.Start();
            this.Close();
        }


       
    }
}
