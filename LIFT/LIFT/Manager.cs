using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Windows.Forms;

namespace LIFT
{
    class Manager
    {
        public House house { get; set; }
        static bool onOff;
        Thread myThread;
        Form1 f;
        public int x { get; set; }
        public int y { get; set; }


        public Manager(Form1 f)
        {
            this.f = f;

        }

        public void StartLift(int size)
        {
            house = new House(size);
        }

        public void RunLift()
        {
            while (onOff)
            {
                x = f.xLift;
                //y = f.yLift;
                Thread.Sleep(1000);
                f.fx = x;
                f.fy = y;

                // f.MoveLift(x, y);

                // out of elevator passengers
                if (house.el.passengers.Count > 0)
                {
                    for (int i = 0; i < house.el.passengers.Count; i++)
                    {
                        if (house.el.passengers[i].pasDistanation == house.el.currentFloor)
                        {
                            house.el.curCapacity -= house.el.passengers[i].weigth;
                            Console.WriteLine("Out pas-r: " + house.el.passengers[i].ToString() + " index " + i);
                            MessageBox.Show("Out of lift passenger: " + house.el.passengers[i].ToString());
                            house.el.passengers.RemoveAt(i);
                        }
                    }
                }
                bool flag;
                //Если лифт пустой - смотрим кто нажал кнопку
                if (house.el.passengers.Count == 0)
                {
                    // going up
                    if (house.el.direction == Direction.UP)
                    {
                        flag = true;

                        if (flag)
                        {
                            // remaind of up
                            for (int i = house.el.currentFloor; i < house.size; i++)
                            {
                                if (house.floors[i].pasUp.Count > 0)
                                {
                                    house.el.direction = Direction.UP;
                                    house.el.distanation = i;
                                    Console.WriteLine("IF #1");
                                    flag = false;
                                }
                            }
                        }
                        if (flag)
                        {
                            // remaind of down
                            for (int i = 1; i <= house.size; i++)
                            {
                                if (house.floors[i].pasDown.Count > 0)
                                {
                                    house.el.direction = Direction.DOWN;
                                    house.el.distanation = i;
                                    Console.WriteLine("IF #2");
                                    flag = false;
                                }
                            }
                        }
                        if (flag)
                        {
                            // remind of up 1 to size
                            for (int i = 1; i < house.el.currentFloor; i++)
                            {
                                if (house.floors[i].pasUp.Count > 0)
                                {
                                    house.el.direction = Direction.UP;
                                    house.el.distanation = i;
                                    Console.WriteLine("IF #3");
                                    flag = false;
                                }
                            }
                        }
                    }
                    // going down
                    else
                    {
                        flag = true;
                        if (flag)
                        {
                            // remaind of down
                            for (int i = 1; i <= house.el.currentFloor; i++)
                            {
                                if (house.floors[i].pasDown.Count > 0)
                                {
                                    house.el.direction = Direction.DOWN;
                                    house.el.distanation = i;
                                    Console.WriteLine("IF #4");
                                    flag = false;
                                }
                            }
                        }

                        if (flag)
                        {
                            // remaind of up
                            for (int i = 1; i < house.size; i++)
                            {
                                if (house.floors[i].pasUp.Count > 0)
                                {
                                    house.el.direction = Direction.UP;
                                    house.el.distanation = i;
                                    Console.WriteLine("IF #5");
                                    flag = false;
                                }
                            }
                        }

                        if (flag)
                        {
                            // remind of up 1 to size
                            for (int i = house.el.currentFloor; i < house.size; i++)
                            {
                                if (house.floors[i].pasDown.Count > 0)
                                {
                                    house.el.direction = Direction.DOWN;
                                    house.el.distanation = i;
                                    Console.WriteLine("IF #6");
                                    flag = false;
                                }
                            }
                        }
                    }
                }
                // move lift


                //move up 
                if (house.el.currentFloor < house.el.distanation)
                {
                    //out of elevator passengers
                    if (house.el.passengers.Count > 0)
                    {
                        for (int i = 0; i < house.el.passengers.Count; i++)
                        {
                            if (house.el.passengers[i].pasDistanation == house.el.currentFloor)
                            {
                                house.el.curCapacity -= house.el.passengers[i].weigth;
                                Console.WriteLine("Out pas-r: " + house.el.passengers[i].ToString() + " index " + i + " MOVE UP");
                                house.el.passengers.RemoveAt(i);
                            }
                        }
                    }
                    //   in of elevator passengers

                    LinkedListNode<Passenger> node = house.floors[house.el.currentFloor].pasUp.First;
                    Console.WriteLine("Move UP");
                    while (node != null)
                    {
                        var next = node.Next;
                        if ((node.Value.weigth + house.el.curCapacity) <= house.el.maxCapacity)
                        {
                            house.el.passengers.Add(node.Value);
                            if (house.el.distanation < node.Value.pasDistanation)
                            {
                                house.el.distanation = node.Value.pasDistanation;
                            }
                            house.el.curCapacity += node.Value.weigth;
                            house.floors[house.el.currentFloor].pasUp.Remove(node);
                           
                        }
                             node = next;
                    }
                    if (house.floors[house.el.currentFloor].pasUp.Count >= 0)
                    {
                        f.Invoke(f.myDelegatePassUp);
                    }
                    house.el.direction = Direction.UP;
                    house.el.currentFloor++;
                    y -= f.VerticalStep;
                }

                // move down 
                else if (house.el.currentFloor > house.el.distanation)
                {
                    // out of elevator passengers
                    if (house.el.passengers.Count > 0)
                    {
                        for (int i = 0; i < house.el.passengers.Count; i++)
                        {
                            if (house.el.passengers[i].pasDistanation == house.el.currentFloor)
                            {
                                house.el.curCapacity -= house.el.passengers[i].weigth;
                                Console.WriteLine("Out pas-r: " + house.el.passengers[i].ToString() + " index " + i + " MOVE DOWN");
                                house.el.passengers.RemoveAt(i);
                            }
                        }
                    }
                    // in of elevator passengers
                    if (house.el.curCapacity < house.el.maxCapacity)
                    {
                        Console.WriteLine("Move DOWN ");
                        LinkedListNode<Passenger> node = house.floors[house.el.currentFloor].pasDown.First;
                        while (node != null)
                        {
                            var next = node.Next;
                            if ((node.Value.weigth + house.el.curCapacity) <= house.el.maxCapacity)
                            {
                                house.el.passengers.Add(node.Value);
                                if (house.el.distanation > node.Value.pasDistanation)
                                {
                                    house.el.distanation = node.Value.pasDistanation;
                                }
                                house.el.curCapacity += node.Value.weigth;
                                house.floors[house.el.currentFloor].pasDown.Remove(node);
                                
                            }
                            node = next;
                        }
                    }

                    if (house.floors[house.el.currentFloor].pasDown.Count >= 0)
                    {
                        f.Invoke(f.myDelegatePassDown);
                    }
                    house.el.direction = Direction.DOWN;
                    house.el.currentFloor--;
                    y += f.VerticalStep;
                }
                else if (house.el.currentFloor == house.el.distanation)
                {
                    //  if (house.el.currentFloor == house.el.distanation)
                    //{
                    Console.WriteLine("!!!!!!!!house.el.currentFloor == house.el.distanation =" + house.el.currentFloor);

                    // out of elevator passengers
                    if (house.el.passengers.Count > 0)
                    {
                        for (int i = 0; i < house.el.passengers.Count; i++)
                        {
                            if (house.el.passengers[i].pasDistanation == house.el.currentFloor)
                            {
                                house.el.curCapacity -= house.el.passengers[i].weigth;
                                Console.WriteLine("Out pas-r: " + house.el.passengers[i].ToString() + " index " + i + " ========= ");
                                house.el.passengers.RemoveAt(i);
                            }
                        }
                    }
                    if (house.floors[house.el.currentFloor].pasUp.Count > 0 || house.floors[house.el.currentFloor].pasDown.Count > 0)
                    {
                        if (house.el.direction == Direction.UP && house.floors[house.el.currentFloor].pasUp.Count > 0)
                        {
                            if (house.el.curCapacity < house.el.maxCapacity)
                            {
                                LinkedListNode<Passenger> node = house.floors[house.el.currentFloor].pasUp.First;
                                while (node != null)
                                {
                                    var next = node.Next;
                                    if ((node.Value.weigth + house.el.curCapacity) <= house.el.maxCapacity)
                                    {
                                        house.el.passengers.Add(node.Value);
                                        if (house.el.distanation < node.Value.pasDistanation)
                                        {
                                            house.el.distanation = node.Value.pasDistanation;

                                            Console.WriteLine("house.el.distanation = node.Value.pasDistanation" + house.el.distanation + " " + node.Value.pasDistanation);
                                        }
                                        house.el.curCapacity += node.Value.weigth;
                                        house.floors[house.el.currentFloor].pasUp.Remove(node);
                                    }
                                        node = next;
                                }
                            }

                            if (house.floors[house.el.currentFloor].pasUp.Count >= 0)
                            {
                                f.Invoke(f.myDelegatePassUp);
                            }
                            house.el.direction = Direction.UP;
                            house.el.currentFloor++;
                            y -= f.VerticalStep;
                            Console.WriteLine("IF #7");
                        }
                        else if (house.el.direction == Direction.UP && house.floors[house.el.currentFloor].pasDown.Count > 0)
                        {
                            if (house.el.curCapacity < house.el.maxCapacity)
                            {
                                LinkedListNode<Passenger> node = house.floors[house.el.currentFloor].pasDown.First;
                                while (node != null)
                                {
                                    var next = node.Next;
                                    if ((node.Value.weigth + house.el.curCapacity) <= house.el.maxCapacity)
                                    {
                                        house.el.passengers.Add(node.Value);
                                        if (house.el.distanation > node.Value.pasDistanation)
                                        {
                                            house.el.distanation = node.Value.pasDistanation;
                                            Console.WriteLine("house.el.distanation = node.Value.pasDistanation" + house.el.distanation + " " + node.Value.pasDistanation);
                                        }
                                        house.el.curCapacity += node.Value.weigth;
                                        house.floors[house.el.currentFloor].pasDown.Remove(node);
                                        
                                    }
                                    node = next;
                                }
                            }

                            if (house.floors[house.el.currentFloor].pasDown.Count >= 0)
                            {
                                f.Invoke(f.myDelegatePassDown);
                            }
                            house.el.direction = Direction.DOWN;
                            house.el.currentFloor--;
                            y += f.VerticalStep;
                            Console.WriteLine("IF #8");
                        }
                        else if (house.el.direction == Direction.DOWN && house.floors[house.el.currentFloor].pasDown.Count > 0)
                        {
                            if (house.el.curCapacity < house.el.maxCapacity)
                            {
                                LinkedListNode<Passenger> node = house.floors[house.el.currentFloor].pasDown.First;
                                while (node != null)
                                {
                                    var next = node.Next;
                                    if ((node.Value.weigth + house.el.curCapacity) <= house.el.maxCapacity)
                                    {
                                        house.el.passengers.Add(node.Value);
                                        if (house.el.distanation > node.Value.pasDistanation)
                                        {
                                            house.el.distanation = node.Value.pasDistanation;
                                            Console.WriteLine("house.el.distanation = node.Value.pasDistanation" + house.el.distanation + " " + node.Value.pasDistanation);
                                        }
                                        house.el.curCapacity += node.Value.weigth;
                                        house.floors[house.el.currentFloor].pasDown.Remove(node);
                                       
                                    }
                                    node = next;
                                }
                            }

                            if (house.floors[house.el.currentFloor].pasDown.Count >= 0)
                            {
                                f.Invoke(f.myDelegatePassDown);
                            }
                            house.el.direction = Direction.DOWN;
                            house.el.currentFloor--;
                            y += f.VerticalStep;
                            Console.WriteLine("IF #9");
                        }
                        else if (house.el.direction == Direction.DOWN && house.floors[house.el.currentFloor].pasUp.Count > 0)
                        {
                            if (house.el.curCapacity < house.el.maxCapacity)
                            {
                                LinkedListNode<Passenger> node = house.floors[house.el.currentFloor].pasUp.First;
                                while (node != null)
                                {
                                    var next = node.Next;
                                    if ((node.Value.weigth + house.el.curCapacity) <= house.el.maxCapacity)
                                    {
                                        house.el.passengers.Add(node.Value);
                                        if (house.el.distanation < node.Value.pasDistanation)
                                        {
                                            house.el.distanation = node.Value.pasDistanation;
                                            Console.WriteLine("house.el.distanation = node.Value.pasDistanation" + house.el.distanation + " " + node.Value.pasDistanation);
                                        }
                                        house.el.curCapacity += node.Value.weigth;
                                        house.floors[house.el.currentFloor].pasUp.Remove(node);
                                        
                                    }
                                    node = next;
                                }
                            }
                            if (house.floors[house.el.currentFloor].pasUp.Count >= 0)
                            {
                                f.Invoke(f.myDelegatePassUp);
                            }
                            house.el.direction = Direction.UP;
                            house.el.currentFloor++;
                            y -= f.VerticalStep;
                            Console.WriteLine("IF #10");
                        }
                    }
                    // }
                }
                f.Invoke(f.myDelegateMoveLift);
                f.Invoke(f.myDelegateInfoLift);
                Console.WriteLine(house.el.ToString());
            }

        }

        Direction pasdir;
        public void RandomPass()
        {
            Random rnd1 = new Random();
            int weigthPas = rnd1.Next(50, 150);
            int curFloor = rnd1.Next(1, house.size + 1);
            int pasDist = rnd1.Next(1, house.size + 1);

            if (curFloor > pasDist)
            {
                pasdir = Direction.DOWN;
            }
            else if (curFloor < pasDist)
            {
                pasdir = Direction.UP;
            }
            else if (curFloor == house.size)
            {
                pasDist = rnd1.Next(1, house.size);
                pasdir = Direction.DOWN;
            }
            else if (curFloor == 1)
            {
                pasDist = rnd1.Next(2, house.size + 1);
                pasdir = Direction.UP;
            }
            else if (curFloor == pasDist)
            {
                if (curFloor != house.size)
                {
                    pasDist = curFloor + 1;
                    pasdir = Direction.UP;
                }
                else
                {
                    pasDist = curFloor - 1;
                    pasdir = Direction.DOWN;
                }
            }
            Passenger pas = new Passenger(weigthPas, curFloor, pasDist, pasdir);
            Console.WriteLine("Pas-r added: " + pas.ToString());

            if (pas.pasDirection == Direction.DOWN)
            {
                house.floors[curFloor].pasDown.AddLast(pas);

                if (f.butDown[curFloor, 0].Visible == false)
                {
                    f.butDown[curFloor, 0].Visible = true;
                    f.butDown[curFloor, 0].Text = pas.weigth + " " + pas.pasDistanation + " " + pas.pasDirection;
                }
                else if (f.butDown[curFloor, 1].Visible == false)
                {
                    f.butDown[curFloor, 1].Visible = true;
                    f.butDown[curFloor, 1].Text = pas.weigth + " " + pas.pasDistanation + " " + pas.pasDirection;
                }
                else if (f.butDown[curFloor, 2].Visible == false)
                {
                    f.butDown[curFloor, 2].Visible = true;
                    f.butDown[curFloor, 2].Text = pas.weigth + " " + pas.pasDistanation + " " + pas.pasDirection;
                }
                else
                {
                    MessageBox.Show("Line is full");
                    pas = null;
                }
            }
            else if (pas.pasDirection == Direction.UP)
            {
                house.floors[curFloor].pasUp.AddFirst(pas);
                if (f.butUp[curFloor, 0].Visible == false)
                {
                    f.butUp[curFloor, 0].Visible = true;
                    f.butUp[curFloor, 0].Text = pas.weigth + " " + pas.pasDistanation + " " + pas.pasDirection;
                }
                else if (f.butUp[curFloor, 1].Visible == false)
                {
                    f.butUp[curFloor, 1].Visible = true;
                    f.butUp[curFloor, 1].Text = pas.weigth + " " + pas.pasDistanation + " " + pas.pasDirection;
                }
                else if (f.butDown[curFloor, 2].Visible == false)
                {
                    f.butUp[curFloor, 2].Visible = true;
                    f.butUp[curFloor, 2].Text = pas.weigth + " " + pas.pasDistanation + " " + pas.pasDirection;
                }
                else
                {
                    MessageBox.Show("Line is full");
                    pas = null;
                }
            }

        }

        public void OnElevator()
        {

            onOff = true;
            myThread = new Thread(RunLift);
            myThread.Start();
        }

        public void OffElevator()
        {
            onOff = false;
            myThread.Abort();
        }
    }
}
