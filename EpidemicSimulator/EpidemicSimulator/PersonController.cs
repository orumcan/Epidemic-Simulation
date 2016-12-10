using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EpidemicSimulator
{
    class PersonController
    {
        Person person;

        public PersonController(Person person)
        {
            this.person = person;
        }

        public void becomeSick(bool isSick)
        {
            person.IsSick = isSick;
        }

        public void becomeInfected(bool isInfected)
        {
            person.IsInfected = isInfected;
        }

        public void die()
        {
            Random rand = new Random();
            //bool death = rand.Next() percentage probability
            //person.setIsAlive(death);
        }

        public void move(Country country)
        {
            //To be implemented...
        }   

        public void decideLeavingDay()
        {
            //to be implemented...
        }

        public void increaseDay()
        {
            person.DayPassed = person.DayPassed + 1;
            if(person.IsInfected == true)
            {
                person.InfectionDay++;
            }
        }
    }
}
