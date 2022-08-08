import axios from 'axios';

const http = axios.create({
    baseURL: "//localhost:9000"
});

export default {
    getAnimals() {
        return http.get('/animals');
    },
    getAnimalByType() {
        return http.get('/animals/type/:type');
    },
    getAnimalById() {
        return http.get('/animals/id/:id');
    },
    getAnimalByName() {
        return http.get('/animals/name/:name');
    }

}