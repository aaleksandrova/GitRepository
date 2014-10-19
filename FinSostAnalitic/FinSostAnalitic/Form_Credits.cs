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
    public partial class Form_Credits : Form
    {
        string curUser;
        Client client;
        List<Credit> clientCredits;
        RegClient regClient = new RegClient();
        Credit credit;
        ListClients form;
        #region Constructor
        public Form_Credits(string current, string inn)
        {
            InitializeComponent();
            curUser = current;
            string str = "Форма добавления (изменения) данных по кредитам контрагента";
            this.Text = str + " / " + curUser;

            client = regClient.ClientSearcher(inn);
            textBox1.Text = client.Name;
            textBox2.Text = client.INN;
            textBox3.Text = client.ID.ToString();
            clientCredits = regClient.SerchCreditsByClientId(client.ID);
            dataGridView1.DataSource = clientCredits;
        }
        #endregion


        #region Gets
        //return name of Client
        public TextBox TextBox1
        {
            get
            {
                return textBox1;
            }
        }

        //return inn of Client
        public TextBox TextBox2
        {
            get
            {
                return textBox2;
            }
        }
        //return id of Client
        public TextBox TextBox3
        {
            get
            {
                return textBox3;
            }
        }
        //return purpose of credit
        public ComboBox ComboBox1
        {
            get
            {
                return comboBox1;
            }
        }
        //return interest rate of credit
        public TextBox TextBox10
        {
            get
            {
                return textBox10;
            }
        }

        //return term of credit
        public TextBox TextBox6
        {
            get
            {
                return textBox6;
            }
        }

        //return amount of credit
        public TextBox TextBox4
        {
            get
            {
                return textBox4;
            }
        }

        //return amount eq of credit
        public TextBox TextBox5
        {
            get
            {
                return textBox5;
            }
        }

        //return valute of credit
        public ComboBox ComboBox2
        {
            get
            {
                return comboBox2;
            }
        }
        //return kind of sequrity of credit
        public ComboBox ComboBox3
        {
            get
            {
                return comboBox3;
            }
        }

        //return desription of sequrity of credit
        public TextBox TextBox7
        {
            get
            {
                return textBox7;
            }
        }

        //return amount of sequrity
        public TextBox TextBox8
        {
            get
            {
                return textBox8;
            }
        }

        //return amount of sequrity for dial
        public TextBox TextBox9
        {
            get
            {
                return textBox9;
            }
        }

        #endregion
        //save to database new credit
        private void button1_Click(object sender, EventArgs e)
        {
            int clientId = int.Parse(textBox3.Text);
            int purpose = regClient.getPurposeId(comboBox1.Text);
            double summa = double.Parse(textBox4.Text);
            string valuta = comboBox2.Text;
            double exchage = regClient.setExchange(comboBox2.Text); ;
            double stavka = double.Parse(textBox10.Text);
            int term = int.Parse(textBox6.Text);
            double sequrity = double.Parse(textBox8.Text);
            string sequrityDescription = textBox7.Text;
            int kindOfSequrity = regClient.getKindSequrityId(comboBox3.Text);
            double summaSeqForDial = double.Parse(textBox9.Text);
            double summaEq = summa * exchage;

            regClient.SaveCreditToDB(clientId, purpose, summa, summaEq, valuta, exchage, stavka, term, sequrity, sequrityDescription, kindOfSequrity, summaSeqForDial);
            dataGridView1.DataSource = null;
            clientCredits = regClient.SerchCreditsByClientId(clientId);
            dataGridView1.DataSource = clientCredits;
        }


        // подтянуть данные в форму из DataGridView
        private void dataGridView1_CellMouseClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            int idCredit = int.Parse(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
            credit = regClient.SerchCreditById(idCredit);
            comboBox1.Text = regClient.getPurpose(credit.Purpose);
            textBox6.Text = credit.Term.ToString();
            textBox4.Text = credit.Summa.ToString();
            textBox5.Text = credit.SummaEq.ToString();
            comboBox2.Text = credit.Valuta;
            comboBox3.Text = regClient.getKindSequrity(credit.KindOfSequrity);
            textBox7.Text = credit.SequrityDescription;
            textBox8.Text = credit.Sequrity.ToString();
            textBox9.Text = credit.SummaSeqForDial.ToString();
            textBox10.Text = credit.Stavka.ToString();
        }

        //close
        private void Form_Credits_FormClosed(object sender, FormClosedEventArgs e)
        {
            form = new ListClients(curUser);
            Thread th = new Thread(P => form.ShowDialog());
            th.Start();
            this.Close();
        }

        //change data about credit and save it to database
        private void button2_Click(object sender, EventArgs e)
        {
            int idCredit = int.Parse(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
            regClient.SubmitCreditChanges(this, idCredit);
           
            this.dataGridView1.DataSource = null;
            clientCredits = regClient.SerchCreditsByClientId(client.ID);
            dataGridView1.DataSource = clientCredits;
        }

        //delite data about credit from database
        private void button3_Click(object sender, EventArgs e)
        {
            int idCredit = int.Parse(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
            regClient.DeleteCredit(idCredit);
            this.dataGridView1.DataSource = null;
            clientCredits = regClient.SerchCreditsByClientId(client.ID);
            dataGridView1.DataSource = clientCredits;
        }


    }
}
