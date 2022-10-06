SELECT *
FROM colors
FULL OUTER JOIN actions on colors.id = actions.color_id;