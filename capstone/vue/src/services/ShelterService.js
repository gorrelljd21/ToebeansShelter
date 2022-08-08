import axios from 'axios';

const http = axios.create({
    baseURL: "//localhost:9000"
});

export default {
    getAnimals() {
        return http.get('/animals');
    },
    getDogs() {
        return http.get('/animals/dog');
    },
    getCats() {
        return http.get('/animals/cat');
    },
    getFarmAnimal() {
        return http.get('/animals/FarmAnimal');
    },
    getSmallAnimal() {
        return http.get('/animals/SmallAnimal');
    },

}