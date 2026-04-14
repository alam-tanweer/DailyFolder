import csv
import random

class City:
    __slots__ = ["__name", "__state", "__lat", "__lng"]

    def __init__(self, name, state, lat, lng):
        self.__name = name
        self.__state = state
        self.__lat = lat
        self.__lng = lng

    def get_name(self):
        return self.__name

    def get_state(self):
        return self.__state

    def get_lat(self):
        return self.__lat

    def get_lng(self):
        return self.__lng

    def __str__(self):
        return self.__name + ", " + self.__state


def read_cities(filename):
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        cities = {}
        next(csv_reader) # skip header
        for record in csv_reader:
            name = record[1]
            state = record[2]
            lat = float(record[6])
            lng = float(record[7])
            city = City(name, state, lat, lng)

            if state not in cities:
                cities[state] = []
            cities[state].append(city)
        return cities

def choose_cities(cities):
    chosen = []
    for state in cities:
        city_list = cities[state]
        chosen.append(random.choice(city_list))
    return chosen

def write_cities(cities, filename):
    with open(filename, "w", newline='') as csv_file:
        csv_writer = csv.writer(csv_file)
        csv_writer.writerow(["Name", "State", "Lat", "Lng"])
        for city in cities:
            csv_writer.writerow([city.get_name(), city.get_state(), 
                city.get_lat(), city.get_lng()])

def main():
    cities = read_cities("data/uscities.csv")
    print(len(cities))
    chosen = choose_cities(cities)
    write_cities(chosen, "data/50cities.csv")

if __name__ == "__main__":
    main()