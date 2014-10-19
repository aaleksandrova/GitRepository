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
    public partial class History : Form
    {
        string curUser;
        RegClient regClient = new RegClient();
        List<Ocenka> list;
        ListClients form;

        #region Constructor
        public History(string current, int id)
        {
            InitializeComponent();
            curUser = current;
            string str = "Кредитная история заемщика";
            this.Text = str + " / " + curUser;
            list = regClient.HistorySeacher(id);
            dataGridView1.DataSource = list;
        }
        #endregion Constructor

        //close form
        private void History_FormClosed(object sender, FormClosedEventArgs e)
        {
            form = new ListClients(curUser);
            Thread th = new Thread(P => form.ShowDialog());
            th.Start();
            this.Close();
        }
    }
}
