/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
class WorldViewModel {
    API_URL = "http://localhost:7070/world/api";

    constructor() {
        this.continents = ko.observableArray([]);
        this.continent = ko.observable("Asia");
        this.countries = ko.observableArray([]);
        fetch(`${this.API_URL}/continents`)
            .then(res => res.json())
            .then(continents => {
                continents.sort();
                this.continents(continents);
            })
    }

    list() {
        fetch(`${this.API_URL}/countries?continent=${this.continent()}`)
            .then(res => res.json())
            .then(countries => {
                countries.sort(
                    (c1,c2) => c2.population - c1.population
                );
                this.countries(countries);
            })
    }
}

let model = new WorldViewModel();

$(document).ready( ()  => {
   ko.applyBindings(model);
});