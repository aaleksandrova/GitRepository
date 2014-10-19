using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LIFT
{
    class House
    {
        public Elevator el { get; set; }
        public Floor[] floors;
        public int size { get; set; }

        public House(int size)
        {
            el = new Elevator();
            el.passengers = new List<Passenger>();
            floors = new Floor[size+1];
            for (int i = 0; i < size+1; i++)
            {
                floors[i] = new Floor();
                floors[i].pasDown = new LinkedList<Passenger>();
                floors[i].pasUp = new LinkedList<Passenger>();
              
            }
            this.size = size;
        }

        
    }
}
