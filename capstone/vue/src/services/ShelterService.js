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
    },
    getPhotoById(animalId) {
        return http.get(`/photos/${animalId}`);
    },
    getAllPhotos() {
        return http.get('/photos')
    },
    getAnimalsPaginated(limit, offset) {
        return http.get(`/animals/limit/${limit}/offset/${offset}`)
    }

}