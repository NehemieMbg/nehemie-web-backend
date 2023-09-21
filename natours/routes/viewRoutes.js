const express = require('express');
const viewsController = require('../controllers/veiwsController');
const authController = require('../controllers/authController');

const router = express.Router();

router.use(authController.isLoggedIn);

// Server side rendering: getting html templates
router.get('/', viewsController.getOverview);
router.get('/tour/:slug', viewsController.getTour);
router.get('/login', viewsController.getLoginForm);

module.exports = router;
