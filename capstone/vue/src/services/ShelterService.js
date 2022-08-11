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
    },
    getPhotosPaginated(limit, offset) {
        return http.get(`/photos/limit/${limit}/offset/${offset}`)
    },
    getVolunteers() {
        return http.get('/volunteers');
    },
    getVolunteerById(volunteer_id) {
        return http.get(`/volunteers/${volunteer_id}`);
    },
    getVolunteerByName(full_name) {
        return http.get(`/volunteers/name/${full_name}`);
    },
    getVolunteerByEmail(email) {
        return http.get(`volunteers/email/${email}`);
    },
    getVolunteerReference(volunteer_id) {
        return http.get(`/volunteers/reference/${volunteer_id}`);
    },
    addNewVolunteer(volunteer) {
        return http.post(`volunteers/submit`, volunteer);
    },

}