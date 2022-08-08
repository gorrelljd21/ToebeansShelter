import axios from 'axios';

const http = axios.create({
    baseURL: "//localhost:9000"
});

export default {
    getPets() {
        return http.get('/pets');
    },
    getDogs() {
        return http.get('/pets/dog');
    },
    getCats() {
        return http.get('/pets/cat');
    },
    getFarmAnimal() {
        return http.get('/pets/FarmAnimal');
    },
    getSmallAnimal() {
        return http.get('/pets/SmallAnimal');
    },

}