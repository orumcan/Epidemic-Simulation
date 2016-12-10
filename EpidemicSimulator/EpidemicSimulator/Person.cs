using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EpidemicSimulator
{
    class Person
    {
        private bool isSick;
        private bool isInfected;
        private bool isAlive;
        private int infectionDay;
        private Country currentCountry;
        private int dayPassed;

        public bool IsSick
        {
            get
            {
                return isSick;
            }

            set
            {
                isSick = value;
            }
        }

        public bool IsInfected
        {
            get
            {
                return isInfected;
            }

            set
            {
                isInfected = value;
            }
        }

        public bool IsAlive
        {
            get
            {
                return isAlive;
            }

            set
            {
                isAlive = value;
            }
        }

        public int InfectionDay
        {
            get
            {
                return infectionDay;
            }

            set
            {
                infectionDay = value;
            }
        }

        internal Country CurrentCountry
        {
            get
            {
                return currentCountry;
            }

            set
            {
                currentCountry = value;
            }
        }

        public int DayPassed
        {
            get
            {
                return dayPassed;
            }

            set
            {
                dayPassed = value;
            }
        }
    }
}
