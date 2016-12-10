using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EpidemicSimulator
{
    class Country
    {
        private List<Country> neighbors;
        private List<Person> people;
        private bool isThereSickPerson;

        public List<Country> neighborsList()
        {
            return neighbors;
        }
    }
}
