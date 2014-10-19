using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace FinSostAnalitic
{
    public partial class Registration : Form
    {
        RegMaker reg;
        public Registration()
        {
            InitializeComponent();
            reg = new RegMaker();
        }

        private void button1_Click(object sender, EventArgs e)
        {

            if (!reg.LoginCheck(textBox1.Text))
            {
                if (reg.PasswordCheck(textBox2.Text, textBox3.Text))
                {
                    if (reg.regestration(textBox1.Text, textBox2.Text, comboBox1.Text))
                        this.Close();
                    else
                        MessageBox.Show("Произошел сбой при регистрации");
                }
                else
                    MessageBox.Show("Пароль должен содержать не менее 8 символов и включать и буквы и цифры");
            }
            else
                MessageBox.Show("Такой логин уже существует");

        }
    }
}
