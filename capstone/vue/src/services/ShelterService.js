import axios from 'axios';


export default {
    getAnimals() {
        return axios.get('/animals');
    },
    getAnimalByType() {
        return axios.get('/animals/type/:type');
    },
    getAnimalById() {
        return axios.get('/animals/id/:id');
    },
    getAnimalByName() {
        return axios.get('/animals/name/:name');
    },
    getPhotoById(animalId) {
        return axios.get(`/photos/${animalId}`);
    },
    getAllPhotos() {
        return axios.get('/photos')
    },
    getAnimalsPaginated(limit, offset) {
        return axios.get(`/animals/limit/${limit}/offset/${offset}`)
    },
    getPhotosPaginated(limit, offset) {
        return axios.get(`/photos/limit/${limit}/offset/${offset}`)
    },
    getVolunteers() {
        return axios.get('/volunteers');
    },
    getVolunteerById(volunteer_id) {
        return axios.get(`/volunteers/${volunteer_id}`);
    },
    getVolunteerByName(full_name) {
        return axios.get(`/volunteers/name/${full_name}`);
    },
    getVolunteerByEmail(email) {
        return axios.get(`volunteers/email/${email}`);
    },
    getVolunteerReference(volunteer_id) {
        return axios.get(`/volunteers/reference/${volunteer_id}`);
    },
    addNewVolunteer(volunteer) {
        return axios.post(`volunteers/submit`, volunteer);
    },
    changeAppStatus(volunteer_id, volunteer) {
        return axios.put(`/volunteers/${volunteer_id}`, volunteer);
    },
    deleteVolunteer(volunteer_id) {
        return axios.delete(`/volunteers/${volunteer_id}`)
    },
    addAnimal(animal) {
        return axios.post(`/animals`, animal);
    },
    updateAnimalCard() {
        return axios.get('/update-pet/:animalId');
    },

}