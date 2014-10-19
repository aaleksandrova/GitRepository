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
    public partial class Form_Ocenka : Form
    {
        string curUser;
        Client client;
        RegClient regClient = new RegClient();
        List<Credit> clientCredits;
        Credit credit;
        ListClients form;
        int totalMark;
        
        #region Constructor
        public Form_Ocenka(string current, string inn)
        {
            InitializeComponent();
            curUser = current;
            string str = "Оценка заемщика";
            this.Text = str + " / " + curUser;

            dataGridView2.Rows.Add();
            dataGridView2.Rows.Add();
            dataGridView2.Rows[0].Cells[0].Value = "Заработная плата";
            dataGridView2.Rows[1].Cells[0].Value = "Другие доходы";
            dataGridView2.Rows[2].Cells[0].Value = "Всего: ";

            dataGridView3.Rows.Add();
            dataGridView3.Rows.Add();
            dataGridView3.Rows.Add();
            dataGridView3.Rows.Add();
            dataGridView3.Rows[0].Cells[0].Value = "Текущие затраты";
            dataGridView3.Rows[1].Cells[0].Value = "Отчисления с заработной платы";
            dataGridView3.Rows[2].Cells[0].Value = "Коммунальные платежи";
            dataGridView3.Rows[3].Cells[0].Value = "Другие расходы";
            dataGridView3.Rows[4].Cells[0].Value = "Всего: ";
            dataGridView4.Rows[0].Cells[0].Value = "Совокупный читый доход: ";


            client = regClient.ClientSearcher(inn);
            textBox2.Text = client.Name;
            textBox3.Text = client.INN;
            textBox1.Text = client.ID.ToString();
            clientCredits = regClient.SerchCreditsByClientId(client.ID);
            dataGridView1.DataSource = clientCredits;
        }
        #endregion Constructor

        #region Gets
        //return ID of Client
        public TextBox TextBox1
        {
            get
            {
                return textBox1;
            }
        }

        //return name of Client
        public TextBox TextBox2
        {
            get
            {
                return textBox2;
            }
        }
        //return inn of Client
        public TextBox TextBox3
        {
            get
            {
                return textBox3;
            }
        }
        //return purpose of credit
        public ComboBox ComboBox19
        {
            get
            {
                return comboBox19;
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
        public ComboBox ComboBox18
        {
            get
            {
                return comboBox18;
            }
        }
        //return kind of sequrity of credit
        public ComboBox ComboBox17
        {
            get
            {
                return comboBox17;
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

        //save to database ocenku
        private void button2_Click(object sender, EventArgs e)
        {
            int clId = int.Parse(textBox1.Text);
            DateTime date = dateTimePicker1.Value;
            int idCategory = regClient.getKlassId(label21.Text.Last().ToString());
            string purpose = comboBox1.Text;
            string sequrity = comboBox2.Text;
            string termOfLoan = comboBox3.Text;
            string salary = comboBox4.Text;
            string totalFamilyIncome = comboBox5.Text;
            string ratioLoanPaymentToNetIncome = comboBox6.Text;
            string existanceOfDeposite = comboBox7.Text;
            string levelOfSequrity = comboBox8.Text;
            string finConditionOfBorrowersFamily = comboBox9.Text;
            string expirienceAtLastPlaceOfWork = comboBox10.Text;
            string reputationOfBorrower = comboBox11.Text;
            string familyComposition = comboBox12.Text;
            string ageOfBorrower = comboBox13.Text;
            string creditHistory = comboBox14.Text;
            string paymentCurrentCredit = comboBox15.Text;
            string byuroeCreditHistory = comboBox16.Text;
            int tMark = totalMark;
            regClient.SaveOcenkaToDB(clId, date, idCategory, purpose, sequrity, termOfLoan, salary, totalFamilyIncome,
                ratioLoanPaymentToNetIncome, existanceOfDeposite, levelOfSequrity, finConditionOfBorrowersFamily,
                expirienceAtLastPlaceOfWork, reputationOfBorrower, familyComposition, ageOfBorrower, creditHistory,
                paymentCurrentCredit, byuroeCreditHistory, tMark);
        }

        // Calculate avarage incomes and outcomes
        private void button4_Click(object sender, EventArgs e)
        {
            dataGridView2.Rows[2].Cells[1].Value = double.Parse(dataGridView2.Rows[1].Cells[1].Value.ToString()) + double.Parse(dataGridView2.Rows[0].Cells[1].Value.ToString());
            dataGridView2.Rows[2].Cells[2].Value = double.Parse(dataGridView2.Rows[1].Cells[2].Value.ToString()) + double.Parse(dataGridView2.Rows[0].Cells[2].Value.ToString());
            dataGridView2.Rows[2].Cells[3].Value = double.Parse(dataGridView2.Rows[1].Cells[3].Value.ToString()) + double.Parse(dataGridView2.Rows[0].Cells[3].Value.ToString());
            dataGridView2.Rows[0].Cells[4].Value = (double.Parse(dataGridView2.Rows[0].Cells[1].Value.ToString()) + double.Parse(dataGridView2.Rows[0].Cells[2].Value.ToString()) + double.Parse(dataGridView2.Rows[0].Cells[3].Value.ToString())) / 3;
            dataGridView2.Rows[1].Cells[4].Value = (double.Parse(dataGridView2.Rows[1].Cells[1].Value.ToString()) + double.Parse(dataGridView2.Rows[1].Cells[2].Value.ToString()) + double.Parse(dataGridView2.Rows[1].Cells[3].Value.ToString())) / 3;
            dataGridView2.Rows[2].Cells[4].Value = double.Parse(dataGridView2.Rows[1].Cells[4].Value.ToString()) + double.Parse(dataGridView2.Rows[0].Cells[4].Value.ToString());

            dataGridView3.Rows[4].Cells[1].Value = double.Parse(dataGridView3.Rows[0].Cells[1].Value.ToString()) + double.Parse(dataGridView3.Rows[1].Cells[1].Value.ToString()) + double.Parse(dataGridView3.Rows[2].Cells[1].Value.ToString()) + double.Parse(dataGridView3.Rows[3].Cells[1].Value.ToString());
            dataGridView3.Rows[4].Cells[2].Value = double.Parse(dataGridView3.Rows[0].Cells[2].Value.ToString()) + double.Parse(dataGridView3.Rows[1].Cells[2].Value.ToString()) + double.Parse(dataGridView3.Rows[2].Cells[2].Value.ToString()) + double.Parse(dataGridView3.Rows[3].Cells[1].Value.ToString());
            dataGridView3.Rows[4].Cells[3].Value = double.Parse(dataGridView3.Rows[0].Cells[3].Value.ToString()) + double.Parse(dataGridView3.Rows[1].Cells[3].Value.ToString()) + double.Parse(dataGridView3.Rows[2].Cells[3].Value.ToString()) + double.Parse(dataGridView3.Rows[3].Cells[1].Value.ToString());
            dataGridView3.Rows[0].Cells[4].Value = (double.Parse(dataGridView3.Rows[0].Cells[1].Value.ToString()) + double.Parse(dataGridView3.Rows[0].Cells[2].Value.ToString()) + double.Parse(dataGridView3.Rows[0].Cells[3].Value.ToString())) / 3;
            dataGridView3.Rows[1].Cells[4].Value = (double.Parse(dataGridView3.Rows[1].Cells[1].Value.ToString()) + double.Parse(dataGridView3.Rows[1].Cells[2].Value.ToString()) + double.Parse(dataGridView3.Rows[1].Cells[3].Value.ToString())) / 3;
            dataGridView3.Rows[2].Cells[4].Value = (double.Parse(dataGridView3.Rows[2].Cells[1].Value.ToString()) + double.Parse(dataGridView3.Rows[2].Cells[2].Value.ToString()) + double.Parse(dataGridView3.Rows[2].Cells[3].Value.ToString())) / 3;
            dataGridView3.Rows[3].Cells[4].Value = (double.Parse(dataGridView3.Rows[3].Cells[1].Value.ToString()) + double.Parse(dataGridView3.Rows[3].Cells[2].Value.ToString()) + double.Parse(dataGridView3.Rows[3].Cells[3].Value.ToString())) / 3;
            dataGridView3.Rows[4].Cells[4].Value = double.Parse(dataGridView3.Rows[0].Cells[4].Value.ToString()) + double.Parse(dataGridView3.Rows[1].Cells[4].Value.ToString()) + double.Parse(dataGridView3.Rows[2].Cells[4].Value.ToString()) + double.Parse(dataGridView3.Rows[3].Cells[4].Value.ToString());

            dataGridView4.Rows[0].Cells[1].Value = double.Parse(dataGridView2.Rows[2].Cells[1].Value.ToString()) - double.Parse(dataGridView3.Rows[4].Cells[1].Value.ToString());
            dataGridView4.Rows[0].Cells[2].Value = double.Parse(dataGridView2.Rows[2].Cells[2].Value.ToString()) - double.Parse(dataGridView3.Rows[4].Cells[2].Value.ToString());
            dataGridView4.Rows[0].Cells[3].Value = double.Parse(dataGridView2.Rows[2].Cells[3].Value.ToString()) - double.Parse(dataGridView3.Rows[4].Cells[3].Value.ToString());
            dataGridView4.Rows[0].Cells[4].Value = double.Parse(dataGridView2.Rows[2].Cells[4].Value.ToString()) - double.Parse(dataGridView3.Rows[4].Cells[3].Value.ToString());



        }

        //save to database new credit
        private void button6_Click(object sender, EventArgs e)
        {
            int clientId = int.Parse(textBox1.Text);
            int purpose = regClient.getPurposeId(comboBox19.Text);
            double summa = double.Parse(textBox4.Text);
            string valuta = comboBox18.Text;
            double exchage = regClient.setExchange(comboBox18.Text); ;
            double stavka = double.Parse(textBox10.Text);
            int term = int.Parse(textBox6.Text);
            double sequrity = double.Parse(textBox8.Text);
            string sequrityDescription = textBox7.Text;
            int kindOfSequrity = regClient.getKindSequrityId(comboBox17.Text);
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
            comboBox19.Text = regClient.getPurpose(credit.Purpose);
            textBox6.Text = credit.Term.ToString();
            textBox4.Text = credit.Summa.ToString();
            textBox5.Text = credit.SummaEq.ToString();
            comboBox18.Text = credit.Valuta;
            comboBox17.Text = regClient.getKindSequrity(credit.KindOfSequrity);
            textBox7.Text = credit.SequrityDescription;
            textBox8.Text = credit.Sequrity.ToString();
            textBox9.Text = credit.SummaSeqForDial.ToString();
            textBox10.Text = credit.Stavka.ToString();
        }

        //close
        private void Form_Ocenka_FormClosed(object sender, FormClosedEventArgs e)
        {
            form = new ListClients(curUser);
            Thread th = new Thread(P => form.ShowDialog());
            th.Start();
            this.Close();
        }

        //change data about credit and save it to database
        private void button5_Click(object sender, EventArgs e)
        {
            int idCredit = int.Parse(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
            regClient.SubmitCreditChanges1(this, idCredit);
            this.dataGridView1.DataSource = null;
            clientCredits = regClient.SerchCreditsByClientId(client.ID);
            dataGridView1.DataSource = clientCredits;
        }

        //delete credit from database
        private void button3_Click(object sender, EventArgs e)
        {
            int idCredit = int.Parse(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
            regClient.DeleteCredit(idCredit);
            this.dataGridView1.DataSource = null;
            clientCredits = regClient.SerchCreditsByClientId(client.ID);
            dataGridView1.DataSource = clientCredits;
        }

        //amount of the monthly payment on the loan of client
        public double AmountMonPayLoan(List<Credit> clientCredits)
        {
            double payment = 0D;
            int count = clientCredits.Count;
            for (int i = 0; i < count; i++)
            {
                payment += clientCredits[i].SummaEq * clientCredits[i].Stavka / 12 + clientCredits[i].SummaEq / clientCredits[i].Term;
            }

            return payment;
        }

        //retio total amount of sequrities to total amount of deals of borrower
        public double RetioSequrityToTotalAmount(List<Credit> clientCredits)
        {
            double amount = 0D;
            double amountSequrity = 0D;
            int count = clientCredits.Count;
            for (int i = 0; i < count; i++)
            {
                amount += clientCredits[i].SummaEq;
                amountSequrity += clientCredits[i].SummaSeqForDial;
            }

            return amountSequrity / amount;
        }

        //calculate the borrower category
        private void button1_Click(object sender, EventArgs e)
        {
            //1.1  Мета отримання кредиту
            int purpose = regClient.returnMarkOfPurpose(comboBox1.Text);

            //1.2 Вид застави
            int sequrity = regClient.returnMarkOfSequruty(comboBox2.Text);

            //1.3 Термін дії кредиту
            int termOfLoan = regClient.returnMarkOfTermOfLoan(comboBox3.Text);

            // 2.1 Cума середньомісячної зарплати Позичальника
            if (double.Parse(dataGridView2.Rows[2].Cells[4].Value.ToString()) >= 10000)
            {
                comboBox4.Text = "Больше 10000 грн";
            }
            else if (double.Parse(dataGridView2.Rows[2].Cells[4].Value.ToString()) < 10000.00 && double.Parse(dataGridView2.Rows[2].Cells[4].Value.ToString()) >= 5000.00)
            {
                comboBox4.Text = "От 5000 до 10000 грн";
            }
            else if (double.Parse(dataGridView2.Rows[2].Cells[4].Value.ToString()) < 5000.00 && double.Parse(dataGridView2.Rows[2].Cells[4].Value.ToString()) >= 2000.00)
            {
                comboBox4.Text = "От 2000 до 5000 грн";
            }
            else
            {
                comboBox4.Text = "Менее 2000 грн";
            }

            int salary = regClient.returnMarkOfSalary(comboBox4.Text);

            //2.2 Сума сукупного сімейного щомісячного чистого доходу та прогноз на майбутнє
            if (double.Parse(dataGridView4.Rows[0].Cells[4].Value.ToString()) >= 20000.00)
            {
                comboBox5.Text = "Больше 20000 грн";
            }
            else if (double.Parse(dataGridView4.Rows[0].Cells[4].Value.ToString()) < 20000.00 && double.Parse(dataGridView4.Rows[0].Cells[4].Value.ToString()) >= 10000.00)
            {
                comboBox5.Text = "От 10000 до 20000 грн";
            }
            else if (double.Parse(dataGridView4.Rows[0].Cells[4].Value.ToString()) < 10000.00 && double.Parse(dataGridView4.Rows[0].Cells[4].Value.ToString()) >= 5000.00)
            {
                comboBox5.Text = "От 5000 до 10000 грн";
            }
            else
            {
                comboBox5.Text = "Менее 5000 грн";
            }

            int totalFamilyIncome = regClient.returnMarkTotalFamilyIncome(comboBox5.Text);

            //2.3 Співвідношення скупного платежу по кредиту до чистого  щомісячного доходу (PTI)
            double payment = AmountMonPayLoan(clientCredits);
            double netIncom = double.Parse(dataGridView4.Rows[0].Cells[4].Value.ToString());
            if ((payment / netIncom) <= 0.75)
            {
                comboBox6.Text = "До 75%";
            }
            else if ((payment / netIncom) > 0.75 && (payment / netIncom) <= 0.8)
            {
                comboBox6.Text = "75-80%";
            }
            else if ((payment / netIncom) > 0.80 && (payment / netIncom) <= 1)
            {
                comboBox6.Text = "80-100";
            }
            else
            {
                comboBox6.Text = "Больше 100%";
            }

            int ratioLoanPaymentToNetIncome = regClient.returnMarkOfRatioLoanPaymentToNetIncome(comboBox6.Text);

            // 2.4 Наявність депозитних вкладів
            int existanceOfDeposite = regClient.returnMarkExistanceOfDeposite(comboBox7.Text);

            // 2.5 Рівень забезпечення
            double ratio = RetioSequrityToTotalAmount(clientCredits);

            if (ratio <= 0.5)
            {
                comboBox8.Text = "Сумма кредита составляет до 50% от стоимости обеспечения";

            }
            else if (ratio > 0.5 && ratio <= 0.85)
            {
                comboBox8.Text = "Сумма кредита составляет 50 - 85% от стоимости обеспечения";

            }
            else if (ratio > 0.85 && ratio <= 1)
            {
                comboBox8.Text = "Сумма кредита составляет 86 - 100% от стоимости обеспечения";
            }
            else
            {
                comboBox8.Text = "Сумма кредита составляет более 100% от стоимости обеспечения";
            }
            int levelOfSequrity = regClient.returnMarkOfLevelOfSequrity(comboBox8.Text);

            // 3.1 Матеріальний стан сім'ї Позичальника
            int finConditionOfBorrowersFamily = regClient.returnMarkOfFinConditionOfBorrowersFamily(comboBox9.Text);

            // 3.2 Зайнятість (місце роботи, стаж на цьому робочому місці)
            int expirienceAtLastPlaceOfWork = regClient.returnMarkOfExpirienceAtLastPlaceOfWork(comboBox10.Text);

            // 3.3	 Репутація Позичальника
            int reputationOfBorrower = regClient.returnMarkOfReputationOfBorrower(comboBox11.Text);

            // 3.4	Склад сім'ї
            int familyComposition = regClient.returnMarkOfFamilyComposition(comboBox12.Text);

            // 3.5	 Вік Позичальника
            int ageOfBorrower = regClient.returnMarkOfAgeOfBorrower(comboBox13.Text);

            // 3.6	 Кредитна історія Позичальника
            int creditHistory = regClient.returnMarkOfCreditHistory(comboBox14.Text);

            // 3.7	 Обслуговування діючих кредитів
            int paymentCurrentCredit = regClient.returnMarkOfPaymentCurrentCredit(comboBox15.Text);

            // 3.8	Інформація отримана з Бюро кредитних Історій
            int byuroeCreditHistory = regClient.returnMarkOfByuroeCreditHistory(comboBox16.Text);

            totalMark = purpose + sequrity + termOfLoan + salary + totalFamilyIncome +
                            ratioLoanPaymentToNetIncome + existanceOfDeposite + levelOfSequrity +
                            finConditionOfBorrowersFamily + expirienceAtLastPlaceOfWork + reputationOfBorrower +
                            familyComposition + ageOfBorrower + creditHistory + paymentCurrentCredit +
                            byuroeCreditHistory;
            label36.Text = "Количество баллов - " + totalMark.ToString();
            if (totalMark >= 70)
            {
                label21.Text = "Класс А";

            }
            else if (totalMark < 70 && totalMark >= 50)
            {
                label21.Text = "Класс Б";
            }
            else if (totalMark < 50 && totalMark >= 25)
            {
                label21.Text = "Класс В";
            }
            else if (totalMark < 25 && totalMark >= 10)
            {
                label21.Text = "Класс Г";
            }
            else
            {
                label21.Text = "Класс Д";
            }
        }

        //change term
        private void comboBox3_MouseClick(object sender, MouseEventArgs e)
        {
            List<string> term1 = new List<string>();
            term1.Add("До 10 лет");
            term1.Add("От 10 до 20 лет");
            term1.Add("Более 20 лет");
            List<string> term2 = new List<string>();
            term2.Add("До 3 лет");
            term2.Add("От 3 до 5 лет");
            term2.Add("Больше 5 лет");
            List<string> term3 = new List<string>();
            term3.Add("До 3 лет");
            term3.Add("От 3 до 5 лет");
            term3.Add("От 5 до 7 лет");
            term3.Add("Больше 7 лет");
            List<string> term4 = new List<string>();
            term4.Add("До 1 года");
            term4.Add("Больше 1 года");

            if (!string.IsNullOrEmpty(comboBox1.Text))
            {

                if (this.comboBox1.Text == "Приобретение недвижимости")
                {
                    foreach (string s in term1)
                    {
                        comboBox3.Items.Add(s);
                    }
                }
                else if (this.comboBox1.Text == "Приобретение автомобиля")
                {
                    foreach (string s in term2)
                    {
                        comboBox3.Items.Add(s);
                    }
                }
                else if (this.comboBox1.Text == "Потребительские нужды под залог")
                {
                    foreach (string s in term3)
                    {
                        comboBox3.Items.Add(s);
                    }
                }
                else if (this.comboBox1.Text == "Потребительские нужды без залога")
                {
                    foreach (string s in term4)
                    {
                        comboBox3.Items.Add(s);
                    }
                }
            }
            else
            {
                MessageBox.Show("Выберите цель кредита!");
            }
        }


        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

            comboBox3.Items.Clear();
        }
    }
}
