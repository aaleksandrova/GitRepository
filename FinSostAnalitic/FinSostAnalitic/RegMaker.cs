using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace FinSostAnalitic
{
    class RegMaker
    {
        FinSostDataContext dataContext = new FinSostDataContext();
        
        public bool LoginCheck(string a)
        {
            var data = from c in dataContext.Users
                       select c;
            foreach (User user in data)
            {
                if (user.Name==a)
                {
                    return true;
                }
            }
            return false;
        }
        public bool PasswordCheck(string a, string b)
        {
            a = a.ToUpper().Trim();
            b = b.ToUpper().Trim();
            if (a == b && a.Length > 7 && Regex.IsMatch(a, "[0-9]") && Regex.IsMatch(a, "[A-ZА-Я]"))
                return true;
            return false;
        }
        public bool regestration(string nam, string pass, string position)
        {
            try
            {
                pass = pass.ToUpper().Trim();
                User user = new User() { Name = nam, Password = pass, Position = position };
                dataContext.Users.InsertOnSubmit(user);
                dataContext.SubmitChanges();
                return true;
            }
            catch (Exception) { }
            return false;
        }
        public List<string> getUsersName()
        {
            var data = from c in dataContext.Users
                       select c;

            List<string> names = new List<string>();
            foreach (User user in data)
            {
                names.Add(user.Name);
            }
            return names;
        }


        public User UserSearcher(string name)
        {
            User data = (from c in dataContext.Users
                        where c.Name == name
                        select c).First();
            return data;
        }

       
    }
}
