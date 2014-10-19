using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LIFT
{
    public class Passenger
    {
        public int weigth { get; set; }
        public int pasCurrentFloor { get; set; }
        public int pasDistanation { get; set; }
        public Direction pasDirection { get; set; }

        public Passenger()
        {

        }
        public Passenger(int weigth, int pasCurrentFloor, int pasDistanation, Direction pasDirection)
        {
            this.weigth = weigth;
            this.pasCurrentFloor = pasCurrentFloor;
            this.pasDistanation = pasDistanation;
            this.pasDirection = pasDirection;
        }
        public override string ToString()
        {
            return "[weigth=" + weigth + ", pasCurrentFloor=" + pasCurrentFloor + ", pasDistanation=" + pasDistanation + ", direction: " + pasDirection + "]";
        }
      
    }
}
