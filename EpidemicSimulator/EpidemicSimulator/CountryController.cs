using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EpidemicSimulator
{
    class CountryController
    {
        private Country country;

        public CountryController(Country country)
        {
            this.country = country;

        }

        public void addNeighbor(Country country)
        {
            country.neighborsList().Add(country);
        }

        public List<Country> getNeighborList()
        {
            return country.neighborsList();
        }

    }
}
