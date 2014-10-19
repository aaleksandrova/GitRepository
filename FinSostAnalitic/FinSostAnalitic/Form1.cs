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
    public partial class Form1 : Form
    {
        RegMaker reg;
        ListClients form;
        Registration registrationForm;
        FinSostDataContext dataContext1 = new FinSostDataContext();
        public Form1()
        {
            InitializeComponent();
            string str = "Регистрация пользователей";
            this.Text = str;
            reg = new RegMaker();
            List<string> users;
            
           
            users = reg.getUsersName();
            if (users.Count > 0)
                comboBox1.DataSource = users;
            else
            {
                reg.regestration("Admin", "password", "Администратор");
                comboBox1.Text = "Admin";
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            User user = reg.UserSearcher(comboBox1.Text);
            if (user.Password == textBox2.Text.ToUpper().TrimEnd())
            {
                if (user.Position == "Администратор")
                {
                    registrationForm = new Registration();
                    Thread th = new Thread(P => registrationForm.ShowDialog());
                    th.Start();
                    this.Close();
                }
                else
                {
                    form = new ListClients(user.Name);
                    Thread th = new Thread(P => form.ShowDialog());
                    th.Start();
                    this.Close();
                }
            }
        }
    }
}
