using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LIFT
{
    public enum Direction { UP, DOWN };

    public class Elevator
    {
        public int distanation { get; set; }
        public int currentFloor { get; set; }
        public Direction direction { get; set; }
        public int maxCapacity { get; set; }
        public int curCapacity { get; set; }
        public List<Passenger> passengers { get; set; }



        public Elevator()
        {
            distanation = 1;
            currentFloor = 1;
            direction = Direction.UP;
            maxCapacity = 450;
            curCapacity = 0;
        }
        public override string ToString()
        {
            return "Elevator [distanation=" + distanation + ", currentFloor=" + currentFloor + ", direction=" + direction +
                ", maxCapacity=" + maxCapacity + ", curCapacity=" + curCapacity + ", passengers.Count=" + passengers.Count + "]";
        }
    }

}
