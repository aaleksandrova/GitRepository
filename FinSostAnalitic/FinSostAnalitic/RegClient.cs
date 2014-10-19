using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace FinSostAnalitic
{
    class RegClient
    {
        FinSostDataContext dataContext = new FinSostDataContext();

        //chacking is there only text
        public bool NameCheck(string a)
        {
            if (Regex.IsMatch(a, "[А-Я]"))
                return true;
            return false;
        }

        // checking is INN correct
        public bool InnCheck(string a)
        {
            if (a.Length == 10 && Regex.IsMatch(a, "[0-9]"))
                return true;
            return false;
        }

        //serch client in database by INN
        // return true if it is there
        public bool ClientSearch(string inn)
        {
            Client data;
            try
            {
                data = (from c in dataContext.Clients
                        where c.INN == inn
                        select c).First();
                if (data != null)
                    return true;

                else
                    return false;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return false;
            }

        }

        //serch client in database by INN
        // return Client
        public Client ClientSearcher(string inn)
        {
            Client data = (from c in dataContext.Clients
                           where c.INN == inn
                           select c).First();
            return data;
        }

        //serch all clients witch are in database 
        public List<Client> ClientsSeacher()
        {
            List<Client> clients = new List<Client>();
            var data = from c in dataContext.Clients
                       select c;
            foreach (Client cl in data)
            {
                clients.Add(cl);
            }
            return clients;
        }

        //return home adress of client
        public Adress AdressSeaherH(int id)
        {

            Adress data = (from c in dataContext.Adresses
                           where c.ClientId == id && c.FlagUrOrFact == 1
                           select c).First();

            return data;
        }

        //return official adress of client
        public Adress AdressSeaherU(int id)
        {

            Adress data = (from c in dataContext.Adresses
                           where c.ClientId == id && c.FlagUrOrFact == 0
                           select c).First();

            return data;
        }

        //return List of family of client
        public List<Family> ClientFamilySeacher(int id)
        {
            List<Family> clientFamily = new List<Family>();
            var data = from c in dataContext.Families
                       where c.ClientId == id
                       select c;
            foreach (Family fam in data)
            {
                clientFamily.Add(fam);
            }
            return clientFamily;
        }

        //save client to database
        public bool SaveClientToDB(string name, string inn, string residentance, DateTime date, string work, string post, string mary)
        {
            try
            {
                Client client = new Client() { Name = name, INN = inn, Residantance = residentance, DateBirsday = Convert.ToDateTime(date), WhereWork = work, Position = post, Mariied = mary };
                dataContext.Clients.InsertOnSubmit(client);
                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;
        }

        //change client and save this changes in to database
        public bool SubmitClientChanges(Form2 form, string inn)
        {
            try
            {
                Client client = (from c in dataContext.Clients
                                 where c.INN == inn
                                 select c).First();
                client.Name = form.TextBox1.Text;
                client.INN = form.TextBox4.Text;
                client.DateBirsday = form.DateTimePicker2.Value;
                client.Residantance = form.ComboBox2.Text;
                client.WhereWork = form.TextBox2.Text;
                client.Position = form.TextBox3.Text;
                client.Mariied = form.ComboBox3.Text;

                Adress adressUr = (from adr in dataContext.Adresses
                                   where adr.ClientId == client.ID && adr.FlagUrOrFact == 1
                                   select adr).First();

                adressUr.Country = form.TextBox5.Text;
                adressUr.Area = form.TextBox6.Text;
                adressUr.City = form.TextBox7.Text;
                adressUr.Street = form.TextBox8.Text;
                adressUr.House = form.TextBox9.Text;
                adressUr.Appartment = form.TextBox10.Text;
                adressUr.ZIPCode = int.Parse(form.TextBox11.Text);

                Adress adressHome = (from adr in dataContext.Adresses
                                     where adr.ClientId == client.ID && adr.FlagUrOrFact == 0
                                     select adr).First();
                adressHome.Country = form.TextBox18.Text;
                adressHome.Area = form.TextBox17.Text;
                adressHome.City = form.TextBox16.Text;
                adressHome.Street = form.TextBox15.Text;
                adressHome.House = form.TextBox14.Text;
                adressHome.Appartment = form.TextBox13.Text;
                adressHome.ZIPCode = int.Parse(form.TextBox12.Text);

                List<Family> fam = (from f in dataContext.Families
                                    where f.ClientId == client.ID
                                    select f).ToList();


                fam = form.DataGridView1;

                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;
        }

        //deleting client
        public bool DeleteClient(string inn)
        {
            try
            {
                Client res1 = (from c in dataContext.Clients
                               where c.INN == inn
                               select c).First();

                dataContext.Clients.DeleteOnSubmit(res1);
                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;
        }

        //save new adress of client ito database
        public bool SaveAdressToDB(int id, string country, string area, string city, string street, string house, string app, int zip, int flag)
        {
            try
            {
                Adress adress = new Adress() { ClientId = id, Country = country, Area = area, City = city, Street = street, House = house, Appartment = app, ZIPCode = zip, FlagUrOrFact = flag };
                dataContext.Adresses.InsertOnSubmit(adress);
                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;

        }

        //save new family unit of client to database
        public bool SaveFamilyToDB(int id, string name, DateTime date, string who)
        {
            try
            {
                Family fam = new Family() { ClientId = id, Name = name, DateBirsday = date, WhoIsForClient = who };
                dataContext.Families.InsertOnSubmit(fam);
                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;

        }

        //save new financial data of client to database
        public bool SaveFinDataToDB(int clId, DateTime date,
            double s1, double s2, double s3, double sa,
            double oi1, double oi2, double oi3, double oia,
            double ti1, double ti2, double ti3, double tia,
            double oc11, double oc12, double oc13, double oc1a,
            double oc21, double oc22, double oc23, double oc2a,
            double oc31, double oc32, double oc33, double oc3a,
            double oc41, double oc42, double oc43, double oc4a,
            double oc51, double oc52, double oc53, double oc5a,
            double tn1, double tn2, double tn3, double tna)
        {
            try
            {
                FinData finData = new FinData()
                {
                    ClientId = clId,
                    DateOcenki = date,
                    Salary1 = s1,
                    Salary2 = s2,
                    Salary3 = s3,
                    SalaryAv = sa,
                    OtherIncome1 = oi1,
                    OtherIncome2 = oi2,
                    OtherIncome3 = oi3,
                    OtherIncomeAv = oia,
                    TotalIncome1 = ti1,
                    TotalIncome2 = ti2,
                    TotalIncome3 = ti3,
                    TotalIncomeAv = tia,
                    Outcome11 = oc11,
                    Outcome12 = oc12,
                    Outcome13 = oc13,
                    Outcome1Av = oc1a,
                    Outcome21 = oc21,
                    Outcome22 = oc22,
                    Outcome23 = oc23,
                    Outcome2Av = oc2a,
                    Outcome31 = oc31,
                    Outcome32 = oc32,
                    Outcome33 = oc33,
                    Outcome3Av = oc3a,
                    Outcome41 = oc41,
                    Outcome42 = oc42,
                    Outcome43 = oc43,
                    Outcome4Av = oc4a,
                    TotalOutcome1 = oc51,
                    TotalOutcome2 = oc52,
                    TotalOutcome3 = oc53,
                    TotalOutcomeSr = oc5a,
                    TotalNetIncome1 = tn1,
                    TotalNetIncome2 = tn2,
                    TotalNetIncome3 = tn3,
                    TotalNetIncomeAv = tna
                };
                dataContext.FinDatas.InsertOnSubmit(finData);
                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;

        }

        //return List of Credit of client by Client ID
        public List<Credit> SerchCreditsByClientId(int id)
        {
            List<Credit> clientCredits = new List<Credit>();
            var data = from c in dataContext.Credits
                       where c.ClientId == id
                       select c;
            foreach (Credit c in data)
            {
                clientCredits.Add(c);
            }
            return clientCredits;
        }

        //return credit of client by cretit Id
        public Credit SerchCreditById(int id)
        {
            Credit data = (from c in dataContext.Credits
                           where c.ID == id
                           select c).First();
            return data;
        }

        // return description of purpose by id
        public string getPurpose(int idPurpose)
        {
            string data = (from c in dataContext.Purposes
                           where c.ID == idPurpose
                           select c).First().Description;
            return data;
        }

        // return id of purpose by description
        public int getPurposeId(string purpose)
        {
            int data = (from c in dataContext.Purposes
                        where c.Description == purpose
                        select c).First().ID;
            return data;
        }

        // return description of kind of sequroty by id
        public string getKindSequrity(int idSequrity)
        {
            string data = (from c in dataContext.Sequrities
                           where c.ID == idSequrity
                           select c).First().Description;
            return data;
        }

        // return id of kind of sequroty by description
        public int getKindSequrityId(string sequrityDescription)
        {
            int data = (from c in dataContext.Sequrities
                        where c.Description == sequrityDescription
                        select c).First().ID;
            return data;
        }

        //save new credit to database
        public bool SaveCreditToDB(int clientId, int purpose, double summa, double summaEq, string valuta, double exchage, double stavka, int term, double sequrity, string sequrityDescription, int kindOfSequrity, double summaSeqForDial)
        {
            try
            {
                Credit credit = new Credit() { ClientId = clientId, Purpose = purpose, Summa = summa, SummaEq = summaEq, Valuta = valuta, Exchage = exchage, Stavka = stavka, Term = term, Sequrity = sequrity, SequrityDescription = sequrityDescription, KindOfSequrity = kindOfSequrity, SummaSeqForDial = summaSeqForDial };
                dataContext.Credits.InsertOnSubmit(credit);
                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;

        }

        //change credit and save this changes to database 
        //for form "Form_Credits"
        public bool SubmitCreditChanges(Form_Credits form, int id)
        {
            try
            {
                Credit credit = (from c in dataContext.Credits
                                 where c.ID == id
                                 select c).First();




                credit.ClientId = int.Parse(form.TextBox3.Text);
                credit.Purpose = getPurposeId(form.ComboBox1.Text);
                credit.Term = int.Parse(form.TextBox6.Text);
                credit.Summa = double.Parse(form.TextBox4.Text);

                credit.Valuta = form.ComboBox2.Text;
                credit.KindOfSequrity = getKindSequrityId(form.ComboBox3.Text);
                credit.SequrityDescription = form.TextBox7.Text;
                credit.Sequrity = double.Parse(form.TextBox8.Text);
                credit.SummaSeqForDial = double.Parse(form.TextBox9.Text);
                credit.Stavka = double.Parse(form.TextBox10.Text);
                credit.Exchage = setExchange(form.ComboBox2.Text);
                credit.SummaEq = credit.Summa * credit.Exchage;

                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;
        }


        //change credit and save this changes to database 
        //for form "Form_Ocenka"
        public bool SubmitCreditChanges1(Form_Ocenka form, int id)
        {
            try
            {
                Credit credit = (from c in dataContext.Credits
                                 where c.ID == id
                                 select c).First();




                credit.ClientId = int.Parse(form.TextBox3.Text);
                credit.Purpose = getPurposeId(form.ComboBox19.Text);
                credit.Term = int.Parse(form.TextBox6.Text);
                credit.Summa = double.Parse(form.TextBox4.Text);

                credit.Valuta = form.ComboBox18.Text;
                credit.KindOfSequrity = getKindSequrityId(form.ComboBox17.Text);
                credit.SequrityDescription = form.TextBox7.Text;
                credit.Sequrity = double.Parse(form.TextBox8.Text);
                credit.SummaSeqForDial = double.Parse(form.TextBox9.Text);
                credit.Stavka = double.Parse(form.TextBox10.Text);
                credit.Exchage = setExchange(form.ComboBox18.Text);
                credit.SummaEq = credit.Summa * credit.Exchage;

                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;
        }

        //delete credit from database
        public bool DeleteCredit(int id)
        {
            try
            {
                Credit credit = (from c in dataContext.Credits
                                 where c.ID == id
                                 select c).First();


                dataContext.Credits.DeleteOnSubmit(credit);
                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;
        }

        //set valute exchange by symbol string of valute
        public double setExchange(string valuta)
        {
            double exchange = 1;
            switch (valuta)
            {
                case "USD":
                    {
                        exchange = (from c in dataContext.ValueExchanges
                                    where c.Description == "USD"
                                    select c).First().Excahnge;
                        break;
                    }
                case "UAH":
                    {
                        exchange = (from c in dataContext.ValueExchanges
                                    where c.Description == "UAH"
                                    select c).First().Excahnge;
                        break;
                    }
                case "EUR":
                    {
                        exchange = (from c in dataContext.ValueExchanges
                                    where c.Description == "EUR"
                                    select c).First().Excahnge;
                        break;
                    }
                case "RUB":
                    {
                        exchange = (from c in dataContext.ValueExchanges
                                    where c.Description == "RUB"
                                    select c).First().Excahnge;
                        break;
                    }

                default:
                    {

                        break;
                    }
            }
            return exchange;
        }

        //return mark of ratio loan payment to net income
        public int returnMarkOfRatioLoanPaymentToNetIncome(string s)
        {
            int mark = (from c in dataContext.RatioLoanPaymentToNetIncomes
                        where c.Description == s
                        select c).First().Mark;

            return mark;
        }

        //return mark of total family income
        public int returnMarkTotalFamilyIncome(string s)
        {
            int mark = (from c in dataContext.TotalFamilyIncomes
                        where c.Description == s
                        select c).First().Mark;

            return mark;
        }

        //return mark of salary of borrower
        public int returnMarkOfSalary(string s)
        {
            int mark = (from c in dataContext.Salaries
                        where c.Description == s
                        select c).First().Mark;

            return mark;
        }

        //return mark of purpose of credit
        public int returnMarkOfPurpose(string s)
        {
            int mark = (from c in dataContext.Purposes
                        where c.Description == s
                        select c).First().Mark;

            return mark;
        }

        //return mark of sequrity
        public int returnMarkOfSequruty(string s)
        {
            int mark = (from c in dataContext.Sequrities
                        where c.Description == s
                        select c).First().Mark;

            return mark;
        }

        //
        public int returnMarkOfTermOfLoan(string s)
        {
            int mark = (from c in dataContext.TermOfLoans
                        where c.Description == s
                        select c).First().Mark;

            return mark;
        }

        public int returnMarkExistanceOfDeposite(string s)
        {
            int mark = (from c in dataContext.ExistanceOfDeposites
                        where c.Description == s
                        select c).First().Mark;
            return mark;
        }

        public int returnMarkOfLevelOfSequrity(string s)
        {
            int mark = (from c in dataContext.LevelOfSequrities
                        where c.Description == s
                        select c).First().Mark;
            return mark;
        }

        public int returnMarkOfFinConditionOfBorrowersFamily(string s)
        {
            int mark = (from c in dataContext.FinConditionOfBorrowersFamilies
                        where c.Description == s
                        select c).First().Mark;
            return mark;
        }
        public int returnMarkOfExpirienceAtLastPlaceOfWork(string s)
        {
            int mark = (from c in dataContext.ExpirienceAtLastPlaceOfWorks
                        where c.Description == s
                        select c).First().Mark;
            return mark;
        }

        public int returnMarkOfReputationOfBorrower(string s)
        {
            int mark = (from c in dataContext.ReputationOfBorrowers
                        where c.Description == s
                        select c).First().Mark;
            return mark;
        }

        public int returnMarkOfFamilyComposition(string s)
        {
            int mark = (from c in dataContext.FamilyCompositions
                        where c.Description == s
                        select c).First().Mark;
            return mark;
        }

        public int returnMarkOfAgeOfBorrower(string s)
        {
            int mark = (from c in dataContext.AgeOfBorrowers
                        where c.Description == s
                        select c).First().Mark;
            return mark;
        }

        public int returnMarkOfCreditHistory(string s)
        {
            int mark = (from c in dataContext.CreditHistories
                        where c.Description == s
                        select c).First().Mark;
            return mark;
        }

        public int returnMarkOfPaymentCurrentCredit(string s)
        {
            int mark = (from c in dataContext.PaymentCurrentCredits
                        where c.Description == s
                        select c).First().Mark;
            return mark;
        }

        public int returnMarkOfByuroeCreditHistory(string s)
        {
            int mark = (from c in dataContext.ByuroeCreditHistories
                        where c.Description == s
                        select c).First().Mark;
            return mark;
        }

        public bool SaveOcenkaToDB(int clId, DateTime date, int idCategory,
            string purpose, string sequrity, string termOfLoan, string salary,
            string totalFamilyIncome, string ratioLoanPaymentToNetIncome,
            string existanceOfDeposite, string levelOfSequrity,
            string finConditionOfBorrowersFamily, string expirienceAtLastPlaceOfWork,
            string reputationOfBorrower, string familyComposition, string ageOfBorrower,
            string creditHistory, string paymentCurrentCredit, string byuroeCreditHistory,
            int totalMark)
        {
            try
            {
                Ocenka ocenka = new Ocenka()
                {
                    ClientId = clId,
                    DateOfOcenki = Convert.ToDateTime(date),
                    IdCategoryOfBorrower = idCategory,
                    PurposeDescription = purpose,
                    SequrityDescription = sequrity,
                    TermOfLoanDescription = termOfLoan,
                    SalaryDescription = salary,
                    TotalFamilyIncomeDescription = totalFamilyIncome,
                    RatioLoanPaymentToNetIncomeDescription = ratioLoanPaymentToNetIncome,
                    ExistanceOfDepositeDescription = existanceOfDeposite,
                    LevelOfSequrityDescription = levelOfSequrity,
                    FinConditionOfBorrowersFamilyDescription = finConditionOfBorrowersFamily,
                    ExpirienceAtLastPlaceOfWorkDescription = expirienceAtLastPlaceOfWork,
                    ReputationOfBorrowerDescription = reputationOfBorrower,
                    FamilyCompositionDescription = familyComposition,
                    AgeOfBorrowerDescription = ageOfBorrower,
                    CreditHistoryDescription = creditHistory,
                    PaymentCurrentCreditDescription = paymentCurrentCredit,
                    ByuroeCreditHistoryDescription = byuroeCreditHistory,
                    TotalMark = totalMark
                };
                dataContext.Ocenkas.InsertOnSubmit(ocenka);
                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;

        }

        public int getKlassId(string klass)
        {
            int data = (from c in dataContext.Klasses
                        where c.Klass1 == klass
                        select c).First().ID;
            return data;
        }

        public List<Ocenka> HistorySeacher(int id)
        {
            List<Ocenka> locenka = new List<Ocenka>();
            var data = from c in dataContext.Ocenkas
                       where c.ClientId == id
                       select c;
            foreach (Ocenka cl in data)
            {
                locenka.Add(cl);
            }
            return locenka;
        }
    }
}
