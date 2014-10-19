using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace LIFT
{
    public partial class Form1 : Form
    {
        public int numberOfFloor = 5;
        Manager manager;

        Graphics Grafic;

        Bitmap Rastr;
        int IndentLeft = 0;
        int IndentRigth = 0;
        int IndentDown = 0;
        int IndentUp = 0;
        public int LengthVerticalAxis, YHorizontalAxis, XMax, VerticalStep;

        public int fx, fy;


        int i;

        public int xLift { get; set; }
        public int yLift { get; set; }

        public delegate void DelegateMoveLift();
        public DelegateMoveLift myDelegateMoveLift;

        public delegate void DelegatePassUp();
        public DelegatePassUp myDelegatePassUp;

        public delegate void DelegatePassDown();
        public DelegatePassDown myDelegatePassDown;

        public delegate void DelegateInfoLift();
        public DelegateInfoLift myDelegateInfoLift;

        public Button[,] butUp;
        public Button[,] butDown;
        private ListBox myListBox;

        public Form1()
        {
            InitializeComponent();
            manager = new Manager(this);
            manager.StartLift(numberOfFloor);
            ResizeRedraw = true;
            myDelegateMoveLift = new DelegateMoveLift(MoveLift);
            myDelegatePassUp = new DelegatePassUp(movePassUp);
            myDelegatePassDown = new DelegatePassDown(movePassDown);
            myDelegateInfoLift = new DelegateInfoLift(writeToListBox);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            manager.RandomPass();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            manager.OnElevator();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            IndentLeft = 35;
            IndentRigth = 15;
            IndentUp = 10;
            IndentDown = 20;
            this.ClientSize = new Size(1500, 468);
            pictureBox1.Size = new Size(800, 468);

            Rastr = new Bitmap(pictureBox1.Width, pictureBox1.Height, pictureBox1.CreateGraphics());

            YHorizontalAxis = pictureBox1.Height - IndentDown;
            XMax = pictureBox1.Width - IndentRigth;
            LengthVerticalAxis = pictureBox1.Height - IndentUp - IndentDown;
            VerticalStep = Convert.ToInt32(LengthVerticalAxis / numberOfFloor);
            Grafic = Graphics.FromImage(Rastr);

            xLift = IndentLeft + pictureBox1.Width/2-panel1.Width/2;
            yLift = YHorizontalAxis - VerticalStep + 12;

            manager.x = xLift;
            manager.y = yLift;
            //Button buttton = new Button();
            //this.Controls.Add(buttton);
            //buttton.Size = new Size(110, 15);
            //buttton.Location = new Point(50, 50);
            //buttton.Parent = pictureBox1;
            butUp = new Button[numberOfFloor + 1 , 3];
            butDown = new Button[numberOfFloor +1 , 3];
            for (int i = 0; i < numberOfFloor + 1; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    Button b = new Button();
                    b.Width = 80;
                    b.Height = 30;
                    b.Visible = false;
                    b.Text = i.ToString();
                    this.Controls.Add(b);
                    b.Parent = pictureBox1;
                    butUp[i,j] = b;
                }
            }
            int sd=20;
           
            for (int j = 0; j < 3; j++)
            {
                for (int i = 1; i < numberOfFloor+1; i++)
                {
                  
                    int Y = YHorizontalAxis - i * VerticalStep;
                    butUp[i , j].Location = new Point(IndentLeft + sd, Y);
                    
                   
                }
                sd += 90;
            }

            for (int i = 0; i <numberOfFloor + 1 ; i++)
            {
                 for (int j = 0; j < 3; j++)
                {
                Button b = new Button();
                b.Width = 80;
                b.Height = 30;
                b.Visible = false;
                b.Text = i.ToString();
                this.Controls.Add(b);
                b.Parent = pictureBox1;
                butDown[i,j] = b;
            }}
            int sd1 = pictureBox1.Width/2+50+10;
          
            for (int j = 0; j < 3; j++)
            {
                for (int i = 1; i < numberOfFloor + 1; i++)
                {

                    int Y = YHorizontalAxis - i * VerticalStep;
                    butDown[i , j].Location = new Point(IndentLeft + sd1, Y);


                }
                sd1 += 90;
            }
            myListBox = new ListBox();
            myListBox.Location = new Point(850, 134);
            myListBox.Name = "myListBox";
            myListBox.Size = new Size(400, 95);
            myListBox.TabIndex = 2;
            this.Controls.Add(myListBox);
        }


        void DrawAxis()
        {
            var Pero = new Pen(Color.Black, 2);
            Grafic.DrawLine(Pero, IndentLeft, YHorizontalAxis,
                                  IndentLeft, IndentUp);
            Grafic.DrawLine(Pero, IndentLeft, YHorizontalAxis,
                                        XMax, YHorizontalAxis);
            Grafic.DrawLine(Pero, IndentLeft, IndentUp,
                                XMax, IndentUp);
            Grafic.DrawLine(Pero, XMax, IndentUp,
                                        XMax, YHorizontalAxis);
        }

        //private void Form1_Paint(object sender, PaintEventArgs e)
        //{
        //    Graphics g = e.Graphics;
        //    g.DrawLine(new Pen(Color.Blue, 4), new Point(10, 10), new Point(100, 100));
        //}

        void DrawHorLine()
        {
            var ThinLine = new Pen(Color.LightGray, 2);
            for (this.i = 1; i < numberOfFloor; i++)
            {
                int Y = YHorizontalAxis - i * VerticalStep;
                Grafic.DrawLine(ThinLine, new Point(IndentLeft, Y), new Point(XMax, Y));
            }
            ThinLine.Dispose();
        }

        public void DrawLift()
        {
            panel1.Width = 100;
            panel1.Height = LengthVerticalAxis / numberOfFloor;
            panel1.Location = new Point(xLift, yLift);
            panel1.Visible = true;
            panel1.Update();
            //var LiftLine = new Pen(Color.Blue, 4);
            //Grafic.DrawRectangle(LiftLine, xLift, yLift, 100, LengthVerticalAxis / numberOfFloor);
            //LiftLine.Dispose();
        }

        public void MoveLift(/*int x, int y*/)
        {
            panel1.Location = new Point(fx, fy);
            //var LiftLine = new Pen(Color.Blue, 4);
            //Grafic.DrawRectangle(LiftLine, x, y, 100, LengthVerticalAxis / numberOfFloor);
            //this.Invalidate(this.ClientRectangle);
            //LiftLine.Dispose();
        }

        public void movePassUp()
        {
            int a = 0;
            for (int i = 0; i < 3; i++)
            {
                butUp[manager.house.el.currentFloor, i].Visible = false;
            }
            if (manager.house.floors[manager.house.el.currentFloor].pasUp.Count > 0)
            {
                LinkedListNode<Passenger> nod1 = manager.house.floors[manager.house.el.currentFloor].pasUp.First;
                while (nod1 != null)
                {
                    butUp[manager.house.el.currentFloor, a].Visible = true;
                    butUp[manager.house.el.currentFloor, a].Text = nod1.Value.weigth + " " + nod1.Value.pasDistanation + " " + nod1.Value.pasDirection;
                    nod1 = nod1.Next;
                    a++;
                }
            }
        }

        public void movePassDown()
        {
            int a = 0;
            for (int i = 0; i < 3; i++)
            {
                butDown[manager.house.el.currentFloor, i].Visible = false;
            }
            if (manager.house.floors[manager.house.el.currentFloor].pasDown.Count > 0)
            {
                LinkedListNode<Passenger> nod1 = manager.house.floors[manager.house.el.currentFloor].pasDown.First;
                while (nod1 != null)
                {
                    butDown[manager.house.el.currentFloor, a].Visible = true;
                    butDown[manager.house.el.currentFloor, a].Text = nod1.Value.weigth + " " + nod1.Value.pasDistanation + " " + nod1.Value.pasDirection;
                    nod1 = nod1.Next;
                    a++;
                }
            }
        }

        public void writeToListBox()
        {
            myListBox.Items.Clear();
            String numberOfPassengers;
            numberOfPassengers = "Number of passengrs in lift: " + manager.house.el.passengers.Count.ToString();
            myListBox.Items.Add(numberOfPassengers);
            String currentCapacity;
            currentCapacity = "Current capacity of lift: " + manager.house.el.curCapacity.ToString();
            myListBox.Items.Add(currentCapacity);
            String passengersInLift;
            for (int i = 0; i < manager.house.el.passengers.Count; i++)
            {
                passengersInLift = "Passenger: " + manager.house.el.passengers[i].ToString();
                myListBox.Items.Add(passengersInLift);
              
            }
            myListBox.Update();
        }
        private void button4_Click(object sender, EventArgs e)
        {
            try
            {
                DrawAxis();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            try
            {
                DrawHorLine();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            try
            {
                DrawLift();
            }
            catch (Exception ex)
            {
                Console.WriteLine("LIFT" + ex.Message);
            }
            pictureBox1.Image = Rastr;
            // Grafic.Dispose();
        }
    }
}
